package calculator;

import util.InputValidator;

import java.util.Collections;
import java.util.List;

public class Tokens {

    private static final int TOKEN_GROUP_SIZE = 2;
    private static final int ODD = 1;
    private static final String SEPERATOR = "\\s+";

    private final List<String> tokens;

    public Tokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public static Tokens from(final String input) {
        InputValidator.validateInput(input);
        return new Tokens(List.of(input.trim().split(SEPERATOR)));
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(tokens);
    }

    public String get(int index) {
        return tokens.get(index);
    }

    public int size() {
        return tokens.size();
    }

    public boolean isOddSize() {
        return tokens.size() % TOKEN_GROUP_SIZE == ODD;
    }
}
