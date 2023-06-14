package org.example.config;

import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

//@Component
//@Configuration
//@Scope(SCOPE_CUCUMBER_GLUE)
public class HttpClient {
    private final String SERVER_URL = "https://the-one-api.dev/v2";
    private final String TOKEN = "Bearer q8-Dw7BW309VBKNssxQ4";
//    private final String ERROR_ENDPOINT_DOES_NOT_EXIST = "Endpoint does not exist.";
    private final String MOVIE_NAME = "The Lord of the Rings Series";
    private RequestSpecification request;
    private Response response;
    private ValidatableResponse json;
    public final String ENDPOINT_MOVIE = "/movie";
    public final String ENDPOINT_BOOK = "/book";
    public final String ENDPOINT_INVALID = "/invalid";

//    @Before
    public void init() {
        RestAssured.baseURI = SERVER_URL;
        RestAssured.oauth2(TOKEN);
    }

    public Response getResponse() {
        return response;
    }

    //    @LocalServerPort
//    private int port;
//    private final RestTemplate restTemplate = new RestTemplate();

//    public String movieEndpoint() {
////        return SERVER_URL + ":" + port + ENDPOINT_MOVIE;
//        return SERVER_URL + ENDPOINT_MOVIE;
//    }

//    public String getMovie(){
////        return restTemplate.getForObject(movieEndpoint(), null).toString();
//    }

//    public int put(final String something) {
//        return restTemplate.postForEntity(movieEndpoint(), something, Void.class).getStatusCodeValue();
//    }

//    public Bag getContents() {
//        return restTemplate.getForEntity(movieEndpoint(), Bag.class).getBody();
//    }

//    public void clean() {
////        restTemplate.delete(movieEndpoint());
//    }


    public RequestSpecification request() {
        request = RestAssured.given()
                .header(HttpHeaders.AUTHORIZATION, TOKEN);
        return request;
    }
    public RequestSpecification requestNoAuth() {
        request = RestAssured.given();
        return request;
    }

    public void callEndpoint(String endpoint) {
        response = null;
        response = request.when().get(SERVER_URL + endpoint);
        System.out.println(response.getBody().asString());
    }

    public void checkStatusCode(int status) {
        response.then().assertThat().statusCode(status);
    }

}
