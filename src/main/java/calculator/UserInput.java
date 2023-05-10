package calculator;
import java.util.Arrays;

import static calculator.TokenUtils.isInteger;

public class UserInput {
    private String input;

    public String getInput() {
        return input;
    }

    public UserInput(String input) {
        if (isNullOrEmpty(input) || containsNonArithmeticOperators(input)) {
            throw new IllegalArgumentException();
        }
        this.input = input;
    }

    private boolean containsNonArithmeticOperators(String input) {
        boolean result = Arrays.stream(Tokenizer.tokenize(input))
                .filter(s -> !isInteger(s))
                .allMatch(s -> s.matches("[+\\-*/]"));
        return !result;
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isBlank();
    }
}
