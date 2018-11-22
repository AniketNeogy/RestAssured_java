package RestAssuredBasics;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssured_BasicsGet {
	
	@Test
	public void test1() {
		
		
		//BaseURL or Host
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//in given block we pass - headers, parameters, request cookies
		given().
				param("location","-33.8670522,151.1957362").
				param("rankby","distance").
				param("type","banks").
				param("key","AIzaSyCynQE5rAr2dKo9bK-DH76dtXPbI-V18qk").
		//in the when block we perform GET/POST?PUT etc and pass the resource information
		when().
				get("/maps/api/place/nearbysearch/json").
		//in the then block we add the assertions
		then().
				assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("results[0].name",equalTo("Cuareadviser Clinic - Physio Healing")).and().
				body("results[0].types[1]",equalTo("health")).and().
				body("results[0].place_id",equalTo("ChIJN1t_tDeuEmsRLTDWH5XW_zo")).and().
				header("Content-Type", "application/json; charset=UTF-8").and().
				header("Vary", "Accept-Language");

	}

}
