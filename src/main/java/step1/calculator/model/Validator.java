package step1.calculator.model;

import java.util.stream.IntStream;

public class Validator {

    public void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }

        String[] tokens = input.split(" ");
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, tokens.length).filter(i -> i % 2 == 0).filter(i -> !isNumber(tokens[i])).findFirst()
            .ifPresent(i -> {
                throw new IllegalArgumentException();
            });
        IntStream.range(0, tokens.length).filter(i -> i % 2 == 1).filter(i -> !isOperator(tokens[i])).findFirst()
            .ifPresent(i -> {
                throw new IllegalArgumentException();
            });
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

}
