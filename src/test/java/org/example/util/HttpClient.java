package org.example.util;

import io.cucumber.spring.ScenarioScope;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class HttpClient {
    @Value("${base_url}")
    private String server_url;
    @Value("${token}")
    private String token;
    private RequestSpecification request;
    private Response response;

    public Response getResponse() {
        return response;
    }

    public RequestSpecification request() {
        request = RestAssured.given()
                .header(HttpHeaders.AUTHORIZATION, token);
        return request;
    }

    public RequestSpecification requestNoAuth() {
        request = RestAssured.given();
        return request;
    }

    public void callEndpoint(String endpoint) {
        System.out.println("ENDPOINT: " + endpoint);
        response = null;
        response = request.when().get(server_url + endpoint);
        System.out.println(response.getBody().asString());
    }

    public void checkStatusCode(int status) {
        response.then().assertThat().statusCode(status);
    }

}

