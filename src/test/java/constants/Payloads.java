package constants;

import java.util.HashMap;

/**
 * Class containing generated payloads used in API requests.
 */
public class Payloads {
    /**
     * Generates a payload map for renewing an access token.
     *
     * @param clientId     The client ID for authentication.
     * @param clientSecret The client secret for authentication.
     * @param grantType    The grant type for token renewal.
     * @param refreshToken The refresh token for authentication.
     * @return A HashMap containing the key-value pairs for the renew access token payload.
     */
    public static HashMap<String, String> renewAccessTokenPayload(
            String clientId, String clientSecret, String grantType, String refreshToken) {
        return new HashMap<>() {{
            put("client_id", clientId);
            put("client_secret", clientSecret);
            put("grant_type", grantType);
            put("refresh_token", refreshToken);
        }};
    }
    /**
     * Generates a payload map for sending a message.
     *
     * @param raw The raw content of the message (represented by coded value).
     * @return A HashMap containing the key-value pair for the send message payload.
     */
    public static HashMap<String, String> sendMessagePayload(String raw) {
        return new HashMap<>() {{
            put("raw", raw);
        }};
    }
}
