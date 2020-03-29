import java.util.Objects;

public class Message {
    private final String delimiter;
    private final String messageBody;

    public Message(final String delimiter, final String messageBody) {
        this.delimiter = delimiter;
        this.messageBody = messageBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(delimiter, message.delimiter) &&
                Objects.equals(messageBody, message.messageBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter, messageBody);
    }
}
