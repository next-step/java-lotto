package stringcalculator;

import java.util.Arrays;

public enum Operator {

    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> (int) x / y);

    private final String sign;
    private final IntCalculator intCalculator;
    private static final String NOT_IN_OPERATOR_SET = "사칙 연산 기호가 아닌 기호는 입력 값이 될 수 없습니다.";

    Operator(String sign, IntCalculator intCalculator) {
        this.sign = sign;
        this.intCalculator = intCalculator;
    }

    public String getSign() {
        return sign;
    }

    public int calculate(int x, int y) {
        return intCalculator.calculate(x, y);
    }

    public static void isValidOperator(String parsedOperator) {
        Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(parsedOperator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_IN_OPERATOR_SET));
    }
}