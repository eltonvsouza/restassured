package org.example.steps;

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
        httpClient.callEndpoint(httpClient.ENDPOINT_MOVIE);
    }

    @Given("user call get invalid endpoint")
    public void userCallGetInvalidEndpoint() {
        httpClient.request();
        httpClient.callEndpoint(httpClient.ENDPOINT_INVALID);
    }

    @Given("user call get movie endpoint")
    public void userCallGetMovieEndpoint() throws Throwable {
        httpClient.request();
        httpClient.callEndpoint(httpClient.ENDPOINT_MOVIE);
    }

    @When("response is {int}")
    public void responseIs(int responseCode) throws Throwable {
        httpClient.checkStatusCode(responseCode);
    }

    @Then("movie name is {string}")
    public void movieNameIs(String movieName) throws Throwable {
//        httpClient.getResponse().then().body("docs[0].name", equalTo(movieName));
        httpClient.getResponse().then().body("docs.size()", is(8), "docs.name", hasItem(movieName));
    }

    @Then("validate error message {string}")
    public void validateErrorMessage(String errorMessage) {
        Assert.assertEquals(httpClient.getResponse().getBody().asString(), errorMessage);
    }

    @Then("message is {string}")
    public void messageIs(String message) {
        httpClient.getResponse().then().body("message", equalTo(message));
    }
}
