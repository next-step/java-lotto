package calculator.domain;

public class Calculator {
    public long calculate(String input) {
        validateNotBlank(input);
        return calculate(slice(input));
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("input should not be blank");
        }
    }

    private static String[] slice(String input) {
        String[] elements = input.split(" ");
        if (elements.length % 2 == 0) {
            throw new IllegalArgumentException("input is invalid format");
        }
        return elements;
    }

    private long calculate(String[] elements) {
        long result = parseNumber(elements[0]);

        for (int i = 1; i < elements.length; i = i + 2) {
            String operator = elements[i];
            long number = parseNumber(elements[i + 1]);
            result = calculateOnce(operator, result, number);
        }

        return result;
    }

    private long parseNumber(String element) {
        try {
            return Long.parseLong(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("element '%s' is not valid number", element));
        }
    }

    private long calculateOnce(String operator, long number1, long number2) {
        return Operator.of(operator).execute(number1, number2);
    }

}
