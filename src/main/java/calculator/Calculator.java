package calculator;

import java.util.stream.Stream;

public class Calculator {

    public long calculate(String input, String regex) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        return Stream.of(input.split(regex)).map(this::parseToken).reduce(0, Integer::sum);
    }

    public long calculate(String input) {
        return calculate(input, ",");
    }

    private Integer parseToken(String token) {
        Integer val = parseToInteger(token);
        if (val <= 0) {
            throw new IllegalArgumentException(String.format("%s is invalid format", token));
        }
        return val;
    }

    private Integer parseToInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s is invalid format", token));
        }
    }

}
