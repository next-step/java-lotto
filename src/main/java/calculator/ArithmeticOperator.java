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

    public int calculate(String operand1, String operand2) {
        return this.biFunction.apply(Integer.parseInt(operand1), Integer.parseInt(operand2));
    }

    public static ArithmeticOperator findEnumByOperatorValue(String operator) {
        for (ArithmeticOperator value : ArithmeticOperator.values()) {
            if (operator.equals(value.getOperator())) {
                return value;
            }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닌 문자는 허용되지 않습니다.");
    }
}
