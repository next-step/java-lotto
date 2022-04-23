package StringCalculator.model;

import java.util.Objects;

public class StringCalculator {
    private static final String DELIMITER = " ";

    public static int calculate(String problem) {
        String[] splitedProblem = problem.split(DELIMITER);
        int result = getIfNumber(splitedProblem[0]);

        for (int i = 1; i < splitedProblem.length; i += 2) {
            result = operation(result, splitedProblem[i], splitedProblem[i + 1]);
        }

        return result;
    }

    private static int getIfNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int operation(int a, String b, String c) {
        if (Objects.equals(b, "+")) {
            return addtion(a, getIfNumber(c));
        }

        if (Objects.equals(b, "-")) {
            return subtraction(a, getIfNumber(c));
        }

        if (Objects.equals(b, "/")) {
            return division(a, getIfNumber(c));
        }

        if (Objects.equals(b, "*")) {
            return multiplication(a, getIfNumber(c));
        }

        throw new RuntimeException();
    }

    private static int addtion(int a, int b) {
        return a + b;
    }

    private static int subtraction(int a, int b) {
        return a - b;
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }
}
