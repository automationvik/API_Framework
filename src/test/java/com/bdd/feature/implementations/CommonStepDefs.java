package com.bdd.feature.implementations;

import java.util.List;
import java.util.logging.Logger;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class CommonStepDefs {
	private RequestSpecification client = RestAssured.given();

	@Given("^I have an endpoint '(.*)'$")
	public void I_have_an_endpoint(String url) throws Throwable {
		client.baseUri(url);
	}

	@When("^I set the headers as:$")
	public void I_set_the_headers_as(DataTable table) throws Throwable {
		for (List<String> header : table.raw())
			client.header(header.get(0), header.get(1));
	}

	private Response resp;

	@When("^I send a GET request$")
	public void I_send_a_GET_request() throws Throwable {
		resp = client.get();
	}

	@Then("^I should get response status code as (\\d+)$")
	public void I_should_get_response_status_code_as(int code) throws Throwable {
		resp.then().statusCode(code);
	}

	@Then("^I have \"([^\"]*)\" key with value as \"([^\"]*)\" in response$")
	public void I_have_key_with_value_as_in_response(String key, String value) throws Throwable {
		resp.then().assertThat().body(key, equalTo(value));
	}

	final static Logger logger = Logger.getLogger("CommonStepDefs");
}
