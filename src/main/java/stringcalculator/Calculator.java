package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static final String DELIMITER = " ";

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public List<String> splitWithSpace(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다: " + input);
        }

        return List.of(input.split(DELIMITER));
    }
}
