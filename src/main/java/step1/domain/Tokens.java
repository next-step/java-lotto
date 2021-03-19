package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tokens {
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_PATTERN = ",|:";
    private static final int GET_CUSTOM_PATTERN = 1;
    private static final int GET_CUSTOM_TEXT = 2;


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
        return Arrays.asList(new Token());
    }

    private String[] stringToArray(String inputText) {
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(GET_CUSTOM_PATTERN);
            return m.group(GET_CUSTOM_TEXT).split(customDelimiter);
        }

        return inputText.split(DEFAULT_PATTERN);
    }

    private boolean isNullAndEmpty(String inputText) {
        return inputText == null
                || inputText.trim().isEmpty();
    }

    public List<Token> getReadOnlyTokens() {
        return Collections.unmodifiableList(tokens);
    }
}
