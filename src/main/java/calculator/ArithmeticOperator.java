package calculator;

import java.util.function.BiFunction;

public enum ArithmeticOperator {

    PLUS("+", (n1, n2) -> (n1 + n2)),
    MINUS("-", (n1, n2) -> (n1 - n2)),
    MULTIPLY("*", (n1, n2) -> (n1 * n2)),
    DIVIDE("/", (n1, n2) -> (n1 / n2)),
    ;

    private static final String OPERATORS = "+-*/";

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    ArithmeticOperator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public String getOperator() {
        return operator;
    }

    public static boolean isValidOperator(String operator) {
        return !OPERATORS.contains(operator);
    }

    public static String calculate(String operand1, String operator, String operand2) {
        int result = 0;
        ArithmeticOperator operatorEnum = findEnumByOperatorValue(operator);
        if (operatorEnum != null) {
            result = operatorEnum.biFunction.apply(Integer.parseInt(operand1), Integer.parseInt(operand2));
        }
        return String.valueOf(result);
    }

    private static ArithmeticOperator findEnumByOperatorValue(String operator) {
        for (ArithmeticOperator value : ArithmeticOperator.values()) {
            if (operator.equals(value.getOperator())) {
                return value;
            }
        }
        return null;
    }
}
