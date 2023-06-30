package tests;



import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class XMLSchemaValidation {
	
	@Test
	public void schemaValidation() throws Exception {
File file = new File("./SoapRequest/Add.xml");
		
		if (file.exists())
			System.out.println(">> file exists <<");
		FileInputStream fileInputstream =new FileInputStream(file);
		String reqBody =IOUtils.toString(fileInputstream, "UTF-8");
		
		baseURI="http://www.dneonline.com";
		
	    given()
        .contentType("text/xml")
        .accept(ContentType.XML)
        .body(reqBody)
        .when()
        .post("/calculator.asmx")
        .then()
        .statusCode(200)
        .log().all()
        .and()
        .body("//*:AddResult.text()", equalTo("7"))
        .and()
        .assertThat().body(matchesXsdInClasspath("C:\\QA\\SeleniumWorkSpace\\RestAssureAutomation\\resources\\Calculator.xsd"));

}
}
