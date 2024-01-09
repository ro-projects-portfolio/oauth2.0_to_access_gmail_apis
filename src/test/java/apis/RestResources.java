package apis;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static apis.SpecificationBuilder.*;
import static constants.EndPoints.TOKEN;
import static io.restassured.RestAssured.given;

/**
 * This class provides static methods for making HTTP requests (REST API calls) using RestAssured library to different endpoints,
 * utilizing request and response specifications from {@link SpecificationBuilder}.
 */
public class RestResources {

    /**
     * App-related requests to renew token.
     * @see TokenGenerator renewToken();
     */
    public static Response postAccount(HashMap<String, String> formParams) {
        return RestAssured.given(getAccountRequestSpecification()).
                formParams(formParams).
                when().
                post(TOKEN).
                then().
                spec(getResponseSpecification()).
                extract().
                response();
    }

    public static Response get(String token, String path) {
        return RestAssured.given(getRequestSpecification()).
                auth().oauth2(token).
                when().
                get(path).
                then().
                spec(getResponseSpecification()).
                extract().
                response();
    }

    public static Response post(String token, HashMap<String, String> payload, String path) {
        return RestAssured.given(getRequestSpecification()).
                auth().oauth2(token).
                body(payload).
                when().
                post(path).
                then().
                spec(getResponseSpecification()).
                extract().
                response();
    }

}
