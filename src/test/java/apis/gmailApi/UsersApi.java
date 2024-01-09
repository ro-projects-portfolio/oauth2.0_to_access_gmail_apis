package apis.gmailApi;

import apis.RestResources;
import io.restassured.response.Response;

import static apis.TokenGenerator.getToken;
import static constants.EndPoints.PROFILE;
import static constants.EndPoints.USERS;
/**
 * This class include HTTP methods for interacting with users endpoints.
 * @see RestResources
 */
public class UsersApi {

    /**
     * Sends a GET request to retrieve the profile information.
     *
     * @param userId The identifier of the user (Email app).
     * @return The response object after making the GET request.
     */
    public static Response get(String userId){
        return RestResources.get(getToken(), USERS + "/" +userId+ PROFILE);
    }

}
