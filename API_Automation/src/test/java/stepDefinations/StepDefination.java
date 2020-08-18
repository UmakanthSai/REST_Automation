package stepDefinations;

import io.cucumber.java.en.Given;
import static org.junit.Assert.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.AddPlace_enum;
import payload.GoogleMap_API;
import payload.Util_SpecBuilder;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

import io.cucumber.java.en.*;

public class StepDefination extends Util_SpecBuilder {

	Response response;
	RequestSpecification reqBuild;
	GoogleMap_API obj1 = new GoogleMap_API();
	AddPlace_enum resourceAPI;
	
	
	@Given("Add Place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		reqBuild = given().spec(req_SpecBuilder()).body(obj1.AddPlace_API(name, language, address));

	}

	@When("user calls {string} using {string} http request")
	public void user_calls_using_http_request(String resource, String http_method) {
		
		resourceAPI = AddPlace_enum.valueOf(resource);
		
		if(http_method.equalsIgnoreCase("POST"))
		response = reqBuild.when().post(resourceAPI.Resource_url());
		else if (http_method.equalsIgnoreCase("GET"))
			response = reqBuild.when().get(resourceAPI.Resource_url());
		
		
		String respon = response.asString();
		System.out.println(respon);
	}

	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String KeyValue, String ExpectedValue) {

		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		js.get(KeyValue);
		assertEquals(js.get(KeyValue).toString(), ExpectedValue);
	}

}
