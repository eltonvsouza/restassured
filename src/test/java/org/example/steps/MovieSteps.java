package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.example.config.HttpClient;
import org.junit.Assert;

import static org.hamcrest.Matchers.*;

@CucumberContextConfiguration
public class MovieSteps {

    //    @Autowired(required = true)
//    private HttpClient httpClient;
    private final HttpClient httpClient = new HttpClient();

    @Given("user call endpoint without auth")
    public void userCallEndpointWithoutAuth() {
        httpClient.requestNoAuth();
        httpClient.callEndpoint("/movie");
    }

    @Given("user call get {string} endpoint")
    public void userCallGetEndpoint(String endpoint) {
        httpClient.request();
        httpClient.callEndpoint("/".concat(endpoint));
    }

    @When("response is {int}")
    public void responseIs(int responseCode) throws Throwable {
        httpClient.checkStatusCode(responseCode);
    }

    @Then("name is {string}")
    public void nameIs(String name) throws Throwable {
//        httpClient.getResponse().then().body("docs[0].name", equalTo(movieName));
        httpClient.getResponse().then().body("docs.name", hasItem(name));
    }

    @Then("validate error message {string}")
    public void validateErrorMessage(String errorMessage) {
        Assert.assertEquals(httpClient.getResponse().getBody().asString(), errorMessage);
    }

    @Then("message is {string}")
    public void messageIs(String message) {
        httpClient.getResponse().then().body("message", equalTo(message));
    }

    @And("list size is {int}")
    public void listSizeIs(int size) {
        httpClient.getResponse().then().body("docs.size()", is(size));
    }
}
