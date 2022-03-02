package calculator;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String userInput;
    private final String delimiter;
    private final String MATCH_STRING = "//(.)\n(.*)";
    private final String DEFAULT_DELIMETER = ",|:";

    public Parser(String userInput) {
        this.userInput = checkInputNullOrZero(userInput);
        this.delimiter = findDelimiter();
    }

    private String checkInputNullOrZero(String userInput) {
        if (Objects.isNull(userInput) || userInput.isEmpty()) {
            return "0";
        }

        return userInput;
    }

    private String findDelimiter() {
        Matcher m = Pattern.compile(MATCH_STRING).matcher(userInput);
        if (m.find()) {
            this.userInput = m.group(2);
            return m.group(1);
        }

        return DEFAULT_DELIMETER;
    }

    public List<Token> parseInput() {
        String[] parseResult = userInput.split(delimiter);
        Token token = new Token(parseResult);

        return token.getTokens();
    }

    public String getUserInput() {
        return userInput;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
