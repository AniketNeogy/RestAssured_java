package RestAssuredBasics;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;


public class RestAssuredBasicsGet2 {
	
	@Test
	public void Test1() {
		
		//set the base URI
		RestAssured.baseURI = "https://reqres.in";
		
		given().
				
		when().
				get("/api/users/2").
		then().
				assertThat().
				statusCode(200).and().body("data.first_name", equalTo("Janet"));
	}

}
