import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeaderParser {
    private static final String MESSAGE_HEADER_REGEX = "//(.)\n(.*)";
    private Pattern messageHeaderPattern;
    private String delimiter;
    private String messageBody;

    public HeaderParser() {
        messageHeaderPattern = Pattern.compile(MESSAGE_HEADER_REGEX);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void parseHeader(String message) {
        Matcher matcher = messageHeaderPattern.matcher(message);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            messageBody = matcher.group(2);
            return;
        }

        messageBody = message;
    }

}
