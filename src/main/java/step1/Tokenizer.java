package step1;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    public static List<String> tokens(String input) {

        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("input is null or empty");
        }

        verifyTokens(input);

        String[] tokens = input.split(" ");
        return Arrays.asList(tokens);


    }

    private static void verifyTokens(String input) {
        String regex = "(?:\\d\\s[\\+\\-\\*\\/]+\\s)+\\d+";
        if(!input.matches(regex)) {
            throw new IllegalArgumentException("invalid token");
        }
    }


    private Tokenizer() {
    }
}
