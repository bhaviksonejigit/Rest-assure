package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {
	@Test
	public void testPut() {
		
		
		JSONObject request =new JSONObject();
		
		request.put("name","Hari");
		request.put("job","technician");
		
		System.out.println(request.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.put("/users/2").then().statusCode(200).log().all();
	
	}
	
	@Test
	public void testPatch() {

		JSONObject request =new JSONObject();
		
		request.put("name","Bhavik");
		request.put("job","Engineer");
		System.out.println(request.toJSONString());
		
		baseURI= "https://reqres.in";
		
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.patch("/api/users/2").then().statusCode(200).log().all();
	
	}
	
	@Test
	public void testdelete() {
		 
				
		baseURI= "https://reqres.in";
		
//		given().header("Content-Type","application/json")
//		.contentType(ContentType.JSON)
//		.accept(ContentType.JSON)
//		.body(request.toJSONString()).
		when().delete("/api/users/2").then().statusCode(204).log().all();
	
	}


}
