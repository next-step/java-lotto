package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String ZERO = "0";
    private static final String DEFAULT_DELIMITER = ",|:";

    private String userInput;
    private String delimiter;

    public Parser(String userInput) {
        this.userInput = checkInputNullOrZero(userInput);
        this.delimiter = findDelimiter();
    }

    private String checkInputNullOrZero(String userInput) {
        if (userInput == null || userInput.equals("")) {
            return ZERO;
        }
        return userInput;
    }

    private String findDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(userInput);
        if (m.find()) {
            this.userInput = m.group(2);
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    public Token parseInput() {
        String[] parseResult = userInput.split(delimiter);
        return new Token(parseResult);
    }

    public String getUserInput() {
        return userInput;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
