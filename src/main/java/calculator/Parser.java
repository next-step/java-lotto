package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String userInput;
    private String delimiter;

    public Parser(String userInput) {
        this.userInput = userInput;
        this.delimiter = findDelimiter();
    }

    private String findDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(userInput);
        if (m.find()) {
            this.userInput = m.group(2);
            return m.group(1);
        }
        return ",|:";
    }
    public List<Token> parseInput() {
        String[] parseResult = userInput.split(delimiter);
        Token token = new Token(parseResult);
        List<Token> tokens = token.getTokens();

        return tokens;
    }

    public String getUserInput() {
        return userInput;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
