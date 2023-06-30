package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

public class GetandPost {
	@Test
	public void testGet() {
		
	baseURI="https://reqres.in/api";
	given().
		get("/users?page=2").
	then().
	statusCode(200).
	body("data[4].first_name", equalTo("George")).
	body("data.first_name", hasItems("George","Rachel"));
	
	}
	@Test
	public void testPost() {
		
	Map<String,Object>map=new HashMap<String,Object>();
//		
//		map.put("name","Bhavik");
//		map.put("job","Engineer");
		
		System.out.println(map);
		JSONObject request=new JSONObject();
		request.put("name","Hari");
		request.put("job","Engineer");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
		post("/users").
		then().statusCode(201).log().all();	}

}