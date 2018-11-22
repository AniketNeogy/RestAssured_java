package RestAssuredBasics;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;


public class RestAssuredBasicsPost1 {
	
	@Test
	public void Test1() {
		
		//set the base URI
		RestAssured.baseURI = "https://reqres.in";
		
		given().
				body("{" + 
						"\"email\": \"sydney@fife\"," + 
						"\"password\": \"pistol\"" + 
						"}").
				header("Content-Type","application/json").
		when().
				post("/api/register").
		then().
				assertThat().
				statusCode(201).and().body("token", equalTo("QpwL5tke4Pnpja7X"));
	}

}
