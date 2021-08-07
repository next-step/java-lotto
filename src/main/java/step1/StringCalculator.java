package step1;

import java.util.Arrays;

public class StringCalculator {

    private final StringTokenizer tokenizer;
    private final StringParser parser;

    public StringCalculator(StringTokenizer tokenizer, StringParser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    public int add(String input) {
        String[] tokens = tokenizer.tokenize(input);
        return Arrays.stream(tokens)
                .mapToInt(parser::parseToInt)
                .sum();
    }
}
