package com.RestAPITest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGETAPIUsingNonBDD {
  @Test
  public void FirstSingleObject() {
	  
	  
	  Response res=RestAssured.get("https://restful-booker.herokuapp.com/booking/72716");
	  
	  System.out.println("status code is "+res.getStatusCode());
	  System.out.println("status line is"+res.getStatusLine());
	  System.out.println("duration time is"+res.timeIn(TimeUnit.MILLISECONDS));
	  
	  System.out.println("-----payload is----");
	  
	  System.out.println(res.asString());
	  
	  System.out.println(res.asPrettyString());
  }
  
  
  @Test  
  public void testlistofusers() {
	  
	  Response res=RestAssured.given().header("x-api-key","reqres_d848a2c9dd5f491d848983a8af630037").get("https://reqres.in/api/users?page=2");
	  
	 int statuscode= res.getStatusCode();
	 
	 System.out.println("status cose is"+statuscode);
	 Assert.assertEquals(statuscode, 200);
	 System.out.println("status code is matched.."+statuscode);
	 
	 System.out.println(res.asPrettyString());
	  
	  //json validation
	 
	int id= res.jsonPath().getInt("data[0].id");
	 Assert.assertEquals(id,7);
	 System.out.println("Id is "+id);
	 
	 
	 //validation email
	String email= res.jsonPath().getString("data.email");
	String exceptedemail="@reqres.in";
	 
	 Assert.assertTrue(email.contains(exceptedemail));
	 
	 
	 System.out.println("email is"+email);
  }
}
