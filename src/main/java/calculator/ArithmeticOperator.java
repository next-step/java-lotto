package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum ArithmeticOperator {

    PLUS("+", (n1, n2) -> (n1 + n2)),
    MINUS("-", (n1, n2) -> (n1 - n2)),
    MULTIPLY("*", (n1, n2) -> (n1 * n2)),
    DIVIDE("/", (n1, n2) -> (n1 / n2)),
    ;

    private static final String OPERATORS = "+-*/";

    private final String operator;
    private final BinaryOperator<Integer> binaryOperator;

    ArithmeticOperator(String operator, BinaryOperator<Integer> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static boolean isValidOperator(String operator) {
        return !OPERATORS.contains(operator);
    }

    public int calculate(String operand1, String operand2) {
        return binaryOperator.apply(Integer.parseInt(operand1), Integer.parseInt(operand2));
    }

    public static ArithmeticOperator findEnumByOperatorValue(String operator) {
        return Arrays.stream(values())
                .filter(value -> operator.equals(value.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닌 문자는 허용되지 않습니다."));
    }
}
