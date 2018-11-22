package RestAssuredBasics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.resouces;
import files.payLoad;


public class End_to_End_CreateUser_ExtractFromResponse_UpdateUser_Refractored {
	
	Properties prop;
	
	@BeforeTest
	private void setUp() {
		prop = new Properties();
		try {
			FileInputStream propFile = new FileInputStream("E:\\Java_Selenium_RestAssured\\Rest_Assured_Prac1\\src\\files\\env.properties");
			prop.load(propFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void endToEndTest1() {
		
		RestAssured.baseURI = prop.getProperty("HOST");
		
		//Task1 : Grab the complete response
		Response res = given()
							.body(payLoad.getCreateUserPayload())
							.header("Content-Type","application/json")
						.when()
					    	.post(resouces.getCreateUserResource())
						.then()
							.assertThat().statusCode(201).and().body("name",equalTo("morpheus")).
						extract()
							.response();
		
		//Task2 : Grab the Name and ID from the response
		String responseString = res.asString();
		JsonPath js = new JsonPath(responseString);
		String Name = js.get("name");	
		
		
		
		//Task3: Place the name value in the PUT request (Update)
		given().
			header("Content-Type","application/json").
			body(payLoad.getUpdateUserPayload(Name)).
		when().
			put(resouces.getUpdateUserResource())
		.then().
			assertThat().
			statusCode(200).and().
			body("job",equalTo("zion resident"));
	}

}
