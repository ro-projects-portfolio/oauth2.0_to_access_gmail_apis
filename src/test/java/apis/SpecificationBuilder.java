package apis;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigurationLoader;

import static constants.EndPoints.GMAIL;
import static constants.EndPoints.V1;

/**
 * This class provides static methods to create {@link RequestSpecification} and {@link ResponseSpecification} objects for API requests.
 * It utilizes {@link RestAssured} library to build and configure specifications for making HTTP requests and validating HTTP responses.
 */
public class SpecificationBuilder {

    /**
     * Builds a request specification for account-related requests.
     *
     * @return The {@link RequestSpecification} for account-related requests.
     */
    public static RequestSpecification getAccountRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigurationLoader.getInstance().getAccountBaseUri()).
                setContentType(ContentType.URLENC).
                log(LogDetail.ALL).
                build();
    }
    /**
     * Builds a request specification for Gmail API requests.
     * Set BaseUri, Path, Content-Type by default.
     *
     * @return The {@link RequestSpecification} for Gmail API requests.
     */
    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigurationLoader.getInstance().getGmailApiBaseUri()).
                setBasePath(GMAIL + V1).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }
    /**
     * Builds a generic response specification.
     *
     * @return The generic {@link ResponseSpecification}.
     */
    public static ResponseSpecification getResponseSpecification(){
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
