package stringCalculator;

public class StringCalculator {

    private static final String INVALID_INPUT_MESSAGE = "입력 값이 유효하지 않습니다.";

    public static int splitAndCalculate(String input) {
        String[] tokens = input.split(" ");
        validateInput(tokens);
        return calculate(tokens, 0);
    }

    private static void validateInput(String[] tokens) {
        if (tokens.length < 1) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static int calculate(String[] tokens, int index) {
        if (index >= tokens.length) {
            return Integer.parseInt(tokens[index - 1]);
        }
        String token = tokens[index];
        if (isOperator(token)) {
            int num1 = calculate(tokens, index + 1);
            int num2 = calculate(tokens, index + 3);
            return calculate(token, num1, num2);
        } else {
            return calculate(tokens, index + 1);
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int calculate(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산입니다.");
        }
    }
}


