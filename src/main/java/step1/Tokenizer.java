package step1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Tokenizer {

    static final Pattern pattern = Pattern.compile("(?:\\d\\s[\\+\\-\\*\\/]+\\s)+\\d+");

    public static List<String> tokens(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("input is null or empty");
        }

        verifyTokens(input);

        String[] tokens = input.split(" ");
        return Arrays.asList(tokens);
    }

    private static void verifyTokens(String input) {
        if(!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("invalid token");
        }
    }

    private Tokenizer() {
    }
}
