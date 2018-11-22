package RestAssuredBasics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class End_to_End_CreateUser_ExtractFromResponse_UpdateUser {
	
	@Test
	public void endToEndTest() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		//Task1 : Grab the complete response
		Response res = 
		given().
				body("{" + 
						"\"name\": \"morpheus\"," + 
						"\"job\": \"leader\"" + 
					"}")
				.header("Content-Type","application/json")
		.when()
			.post("/api/users")
		.then()
			.assertThat().statusCode(201).and().body("name",equalTo("morpheus")).
		extract().response();

		String responseString = res.asString();
		System.out.println(responseString);
		
		//Task2 : Grab the Name and ID from the response
		JsonPath js = new JsonPath(responseString);
		String Name = js.get("name");	
		
		//Task3: Place the name value in the PUT request (Update)
		given().
			header("Content-Type","application/json").
			body("{"+ 
					"\"name\": \""+Name+"\"," + 
					"\"job\": \"zion resident\"" + 
					"}").
		when().
			put("/api/users/2")
		.then().
			assertThat().
			statusCode(200).and().
			body("job",equalTo("zion resident"));
	}

}
