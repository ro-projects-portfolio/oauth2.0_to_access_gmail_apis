package apis.gmailApi;


import apis.RestResources;
import io.restassured.response.Response;

import static apis.TokenGenerator.getToken;
import static constants.EndPoints.*;
import static constants.Payloads.sendMessagePayload;
/**
 * This class include HTTP methods for interacting with users.messages endpoints.
 * @see RestResources
 */
public class UsersMessagesApi {


    /**
     * Sends a POST request to send a message.
     *
     * @param raw    The content of the message to be sent .
     * @param userId The identifier of the user (Email app).
     * @return The response object after making the POST request.
     */
    public static Response post(String raw, String userId) {
        return RestResources.post(
                getToken(),
                sendMessagePayload(raw),
                USERS + "/" + userId + MESSAGES + SEND
        );
    }

}