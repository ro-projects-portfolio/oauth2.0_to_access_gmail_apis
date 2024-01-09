package apis;

import constants.Payloads;
import io.restassured.response.Response;
import utils.ConfigurationLoader;

import java.time.Instant;
/**
 * This class is responsible for managing access tokens..
 * It ensures that a valid access token is always available and renews it when necessary.
 */
public class TokenGenerator {
    private static String accessToken;
    private static Instant expiryTime; // this variable keep expiration time info of the current access token

    /**
     * Retrieves the current access token. If the token is null or has expired, it attempts to renew it.
     * If the token is successfully renewed, the new access token and its expiration time are stored.
     *
     * @return The current access token.
     * @throws RuntimeException If there is an issue with obtaining or renewing the token.
     */
    public synchronized static String getToken(){
        try{
            if(accessToken == null || Instant.now().isAfter(expiryTime)){
                Response response = renewToken();
                accessToken = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiryTime = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
            } else{
                System.out.println("Token is good to use");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failure with getting token");
        }
        return accessToken;
    }
    /**
     * This method sends a request to the account service to renew the access token based on the client ID,
     * client secret, grant type, and refresh token.
     *
     * @return The response containing the renewed access token.
     * @throws RuntimeException If the renewal process fails or the response status code is not 200.
     * @see RestResources
     */
    private static Response renewToken(){

        Response response = RestResources.postAccount(
                Payloads.renewAccessTokenPayload(
                        // Credentials from .properties file
                ConfigurationLoader.getInstance().getClientId(),
                ConfigurationLoader.getInstance().getClientSecret(),
                ConfigurationLoader.getInstance().getGrantType(),
                ConfigurationLoader.getInstance().getRefreshToken()
                ));

        if(response.statusCode() != 200)
            throw new RuntimeException("Renew Token failed!!!");
        return response;
    }

}
