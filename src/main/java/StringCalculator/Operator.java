package StringCalculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+", (int sum, int number) -> sum + number),
    MINUS("-", (int sum, int number) -> sum - number),
    MULTIPLY("*", (int sum, int number) -> sum * number),
    DIVIDE("/", (int sum, int number) -> sum / number);
    private final String value;
    private final Calculator calculator;


    Operator(String value, Calculator calculator) {
        this.value = value;
        this.calculator = calculator;
    }

    public static Operator from(String rawOperator) {
        return Arrays.stream(values())
                .filter(operator -> operator.value.equals(rawOperator))
                .findFirst()
                .orElseThrow(() ->new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public int calculate(int sum, int number) {
        return calculator.calculate(sum, number);
    }
}
