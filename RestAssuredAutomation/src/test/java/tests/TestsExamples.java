package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples {
	
	@Test
	public void test_1() {
		
		Response response =RestAssured.get("https://reqres.in/api/users/2");
	
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test
	public void test_2() {
		
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given().get("users?page=2").then()
		.statusCode(200)
		.body("data[1].id",equalTo(8))
		.log().all();
		
	}

}
