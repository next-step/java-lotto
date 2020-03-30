package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {
    private static final String MESSAGE_HEADER_REGEX = "//(.)\n(.*)";
    private Pattern messageHeaderPattern;

    public MessageParser() {
        messageHeaderPattern = Pattern.compile(MESSAGE_HEADER_REGEX);
    }

    public Message parse(String message) {
        Matcher matcher = messageHeaderPattern.matcher(message);
        if (matcher.find()) {
            return new Message(matcher.group(1), matcher.group(2));
        }
        return new Message(null, message);
    }
}
