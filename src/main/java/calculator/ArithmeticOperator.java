package calculator;

public enum ArithmeticOperator {

    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"),
    ;

    private static final String OPERATORS = "+-*/";

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static boolean isValidOperator(String operator) {
        return !OPERATORS.contains(operator);
    }

    public static String calculate(String operand1, String operator, String operand2) {

        int result = 0;

        if (PLUS.getOperator().equals(operator)) {
            result = Integer.parseInt(operand1) + Integer.parseInt(operand2);
        }

        if (MINUS.getOperator().equals(operator)) {
            result = Integer.parseInt(operand1) - Integer.parseInt(operand2);
        }

        if (MULTIPLY.getOperator().equals(operator)) {
            result = Integer.parseInt(operand1) * Integer.parseInt(operand2);
        }

        if (DIVIDE.getOperator().equals(operator)) {
            result = Integer.parseInt(operand1) / Integer.parseInt(operand2);
        }

        return String.valueOf(result);
    }
}
