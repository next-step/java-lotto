package lotto;

import java.util.regex.Pattern;

public class TextBasedCalculator {
    private final String inputExpression;

    public TextBasedCalculator(String inputText) {
        validate(inputText);
        this.inputExpression = inputText;
    }

    private void validate(String input) {
        String validFormatRegex = "^-?\\d+(\\s[+\\-*/]\\s-?\\d+)*$";
        String divideByZeroRegex = ".*\\/\\s-?0(\\s|$).*";

        if (!Pattern.matches(validFormatRegex, input)) {
            throw new IllegalArgumentException("invalid format text : " + input);
        }

        if (Pattern.matches(divideByZeroRegex, input)) {
            throw new IllegalArgumentException("invalid format text : " + input);
        }
    }

    public int calculate() {
        String[] tokens = inputExpression.split(" ");

        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            result = applyOperator(result, tokens[i], Integer.parseInt(tokens[i + 1]));
        }
        return result;
    }

    private static int applyOperator(int left, String operator, int right) {
        if (operator.equals("+")) return left + right;
        if (operator.equals("-")) return left - right;
        if (operator.equals("*")) return left * right;
        if (operator.equals("/")) return left / right;
        throw new IllegalArgumentException("unsupported operator : " + operator);
    }
}
