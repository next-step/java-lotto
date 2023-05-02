package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {

    private static final String WHITESPACE = " ";

    public static List<String> devide(String input) {
        return Arrays.stream(input.trim().split(WHITESPACE)).collect(Collectors.toList());
    }

}
