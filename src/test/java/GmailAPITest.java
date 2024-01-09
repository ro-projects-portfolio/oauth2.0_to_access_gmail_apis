import apis.gmailApi.UsersApi;
import apis.gmailApi.UsersMessagesApi;
import constants.StatusCode;
import io.restassured.response.Response;
import objects.Message;
import objects.MessageBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurationLoader;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.MessageUtils.getBase64EncodedMessage;
import static utils.MessageUtils.getMessageTemplate;


public class GmailAPITest {

    private String encodedMessage;

    @BeforeMethod
    public void generateMessage() {
        Message message = new MessageBuilder()
                .setSender(ConfigurationLoader.getInstance().getUserId())
                .setRecipient("") // provide recipient email
                .setSubject("Test message")
                .setContent("Hello, this message has been sent from Gmail APIs")
                .build(); // Message is created as an object using builder pattern
        encodedMessage = getBase64EncodedMessage(getMessageTemplate(message)); // assign class variable

    }

    @Test
    public void getUserProfile() {
        Response response = UsersApi.get(ConfigurationLoader.getInstance().getUserId());
        assertThat(
                response.statusCode(), equalTo(StatusCode.OK_200.getCode())
        );
    }

    @Test
    public void sendMessage() {
        Response response = UsersMessagesApi.post(encodedMessage, ConfigurationLoader.getInstance().getUserId());
        assertThat(
                response.statusCode(), equalTo(StatusCode.OK_200.getCode())
        );
    }
}



