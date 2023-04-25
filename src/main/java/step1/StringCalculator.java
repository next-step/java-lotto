package step1;

import java.util.List;

public class StringCalculator {

    private static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> tokenize(String input) {
        return List.of(input.split(" "));
    }

    public int calculate(String input) {
        validate(input);
        List<String> inputArray = tokenize(input);
        Expression expression = new Expression(inputArray);
        return expression.execute();
    }
}
