package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tokens {
    private final List<Token> tokens;

    public Tokens(String inputText) {
        this.tokens = createTokens(inputText);
    }

    private List<Token> createTokens(String inputText) {
        if (isNullAndEmpty(inputText)) {
            return createZeroToken();
        };

        return Arrays.stream(stringToArray(inputText))
                .map(Token::new)
                .collect(Collectors.toList());
    }

    private List<Token> createZeroToken() {
        List<Token> resultTokens = new ArrayList<>();
        resultTokens.add(new Token());
        return resultTokens;
    }

    private String[] stringToArray(String inputText) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return inputText.split(",|:");
    }

    private boolean isNullAndEmpty(String inputText) {
        return inputText == null
                || inputText.trim().isEmpty();
    }

    public List<Token> getReadOnlyTokens() {
        return Collections.unmodifiableList(tokens);
    }
}
