package parse;

import token.Tokens;

import java.util.List;

public class Parser {
    public static final Tokens parse(String text) {
        validateEmpty(text);
        List<String> splits = Splitter.split(text, Splitter.BLANK);
        return Tokens.from(splits);
    }

    private static void validateEmpty(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
