package caculator;

public class StringCalculator {
    public static final String SPLIT_DELIMITER = " ";
    public static final String OPERATOR_ADD = "+";
    public static final String OPERATOR_SUBTRACT = "-";
    public static final String OPERATOR_MULTIPLY = "*";
    public static final String OPERATOR_DIVIDE = "/";

    public static int calculate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }

        String[] textArray = input.split(SPLIT_DELIMITER);
        int result = Integer.parseInt(textArray[0]);

        for (int i=1; i<textArray.length; i+=2){
            String operator = textArray[i];
            int operand = Integer.parseInt(textArray[i+1]);
            result = calculateOnce(result, operand, operator);
        }
        return result;
    }

    private static int calculateOnce(int operand1, int operand2, String operator) {
        if (operator.equals(OPERATOR_ADD)) {
            return add(operand1, operand2);
        }
        if (operator.equals(OPERATOR_SUBTRACT)) {
            return subtract(operand1, operand2);
        }
        if (operator.equals(OPERATOR_MULTIPLY)) {
            return multiply(operand1, operand2);
        }
        if (operator.equals(OPERATOR_DIVIDE)) {
            return divide(operand1, operand2);
        }

        throw new IllegalArgumentException(String.format("Invalid arithmetic operator %s", operator));
    }

    private static int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private static int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private static int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private static int divide(int operand1, int operand2) {
        return (int) Math.floor(operand1 / operand2);
    }
}
