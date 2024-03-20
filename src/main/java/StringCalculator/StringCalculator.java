package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CHECK_NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final int CALCULATE_CONDITION = 2;

    public static int calculate(String input) {
        validate(input);
        
        List<String> strings = Arrays.asList(input.split(" "));
        Stack<Integer> operands = new Stack<>();
        int result = 0;
        String operator = null;
        for (String string : strings) {
            if (isNumber(string)) {
                operands.push(Integer.parseInt(string));
            } else {
                operator = string;
            }

            if (operands.size() == CALCULATE_CONDITION) {

                if (Objects.isNull(operator)) {
                    throw new IllegalArgumentException();
                }

                int rightOperand = operands.pop();
                int leftOperand = operands.pop();

                int calculateResult = 0;
                if (operator.equals("+")) {
                    calculateResult = leftOperand + rightOperand;
                    result = calculateResult;
                }

                if (operator.equals("-")) {
                    calculateResult = leftOperand - rightOperand;
                    result = calculateResult;
                }

                if (operator.equals("/")) {
                    calculateResult = leftOperand / rightOperand;
                    result = calculateResult;
                }

                if (operator.equals("*")) {
                    calculateResult = leftOperand * rightOperand;
                    result = calculateResult;
                }
                operands.clear();
                operands.push(calculateResult);
            }
        }
        return result;
    }

    private static void validate(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException();
        }

        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumber(String input) {
        if (input.isBlank() || input.isEmpty()) {
            return false;
        }
        return CHECK_NUMBER_PATTERN.matcher(input).matches();
    }
}
