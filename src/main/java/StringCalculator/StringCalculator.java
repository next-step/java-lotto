package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class StringCalculator {

    private static Pattern CHECK_NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static int CALCULATE_CONDITION = 2;

    public static int calculate(String input) {
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
                int rightOperand = operands.pop();
                int leftOperand = operands.pop();

                if (operator.equals("+")) {
                    int calculateResult = leftOperand + rightOperand;
                    result += calculateResult;
                }
            }
        }
        return result;
    }

    private static boolean isNumber(String input) {
        if (input.isBlank() || input.isEmpty()) {
            return false;
        }
        return CHECK_NUMBER_PATTERN.matcher(input).matches();
    }
}
