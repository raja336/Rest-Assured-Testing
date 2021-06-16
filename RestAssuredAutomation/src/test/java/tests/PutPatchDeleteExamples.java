package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Raja");
		request.put("job","developer");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given()
		.header("Content_Type",ContentType.JSON)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/2")
		.then()
		.statusCode(HttpStatus.SC_OK)
		.log().all(); //to see all the response
	}
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Raja");
		request.put("job","developer");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		
		given()
		.header("Content_Type",ContentType.JSON)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("/api/users/2")
		.then()
		.statusCode(HttpStatus.SC_OK)
		.log().all(); //to see all the response
	}

	@Test
	public void testDelete() {
		
		baseURI="https://reqres.in";
		given()
		.when()
		.delete("/api/users/2")
		.then()
		.statusCode(HttpStatus.SC_NO_CONTENT)
		.log().all(); //to see all the response
	}
}
