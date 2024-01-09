package utils;

import objects.Message;

import java.util.Base64;

/**
 * Utility class for working with email messages.
 */
public class MessageUtils {

    /**
     * Creates a message template string based on the provided {@link Message} object.
     * The template includes information such as sender, recipient, subject, and content.
     *
     * @param message The {@link Message} object containing email details.
     * @return A formatted message template string.
     */
    public static String getMessageTemplate (Message message){
        return  "From: "+message.sender()+"\n" +
                "To: "+message.recipient()+"\n" +
                "Subject: "+message.subject()+"\n" +
                "\n" +
                message.content();
    }

    /**
     * Encodes the provided message string into {@link Base64} format.
     *
     * @param message The message to be encoded.
     * @return The {@link Base64} encoded representation of the message.
     */
    public static String getBase64EncodedMessage (String message) {
        return Base64.getUrlEncoder().encodeToString(message.getBytes());
    }
}
