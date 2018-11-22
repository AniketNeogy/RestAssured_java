package RestAssuredBasics;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;


public class RestAssuredBasicsPost2 {
	
	@Test
	public void Test1() {
		
		//set the base URI
		RestAssured.baseURI = "https://reqres.in";
		
		given().
				body("{" + 
						"\"name\": \"morpheus\"," + 
						"\"job\": \"leader\"" + 
						"}").
				header("Content-Type","application/json").
		when().
				post("/api/users").
		then().
				assertThat().
				statusCode(201).and().
				body("name", equalTo("morpheus")).and().
				body("job", equalTo("leader"));
	}

}
