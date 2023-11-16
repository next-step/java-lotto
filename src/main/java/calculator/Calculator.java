package calculator;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String value) {
        String[] tokens = value.split(" ");
        int result = stringToInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int number = stringToInt(tokens[i + 1]);
            result = calculate(operator, result, number);
        }
        return result;
    }

    private static int stringToInt(String token) {
        return Integer.parseInt(token);
    }

    private static int calculate(String operator, int result, int number) {

        if (!(operator.contains("+") || operator.contains("-") || operator.contains("*") || operator.contains("/"))) {
            throw new IllegalArgumentException();
        }

        if (operator.equals("+")) {
            result += number;
        }
        if (operator.equals("-")) {
            result -= number;
        }
        if (operator.equals("*")) {
            result *= number;
        }
        if (operator.equals("/")) {
            validate(result, number);
            result /= number;
        }
        return result;
    }

    private static void validate(int first, int second) {
        if (first % second != 0) {
            throw new IllegalArgumentException();
        }
    }

}
