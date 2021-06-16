package tests;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
//	@Test
	public void testGet() {
		
		baseURI="https://reqres.in/api/";
		given().get("users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George,Rachel"));
	}

	@Test
	public void testPost() {
		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("name", "Raja");
//		map.put("job","developer");
		
//		System.out.println(map);
		
//		JSONObject request = new JSONObject(map);
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
		.post("/users")
		.then()
		.statusCode(HttpStatus.SC_CREATED)
		.log().all(); //to see all the response
	}
}
