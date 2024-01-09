package objects;


/**
 * Builder class for creating instances of the {@link Message} class(record).
 * This class provides a fluent interface for setting the properties of an email message, including
 * sender, recipient, subject, and content.
 *
 * <p>Usage:</p>
 * <pre>
 * Message email = new MessageBuilder()
 *     .setSender("sender@example.com")
 *     .setRecipient("recipient@example.com")
 *     .setSubject("Hello")
 *     .setContent("This is the email content.")
 *     .build();
 * </pre>
 */
public class MessageBuilder {
    private String sender;
    private String recipient;
    private String subject;
    private String content;


    public MessageBuilder setSender(String sender) {
        this.sender=sender;
        return this;
    }

    public MessageBuilder setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public MessageBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public MessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }
    /**
     * Builds an instance of the {@link Message} class with the specified properties.
     *
     * @return An instance of the {@link Message} class.
     */
    public Message build (){
        return new Message(
                this.sender,
                this.recipient,
                this.subject,
                this.content
        ); // This method is crucial if you use Builder Pattern with external class
    }
}
