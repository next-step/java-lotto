package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+",(num1, num2) -> num1 + num2),
    MINUS("-",(num1, num2) -> num1 - num2),
    MULTIPLY("*",(num1, num2) -> num1 * num2),
    DIVIDE("/",(num1, num2) -> num1 / num2);

    private static final String SIGN_ERROR_MASSAGE = "올바른 기호가 아닙니다.";

    private String sign;
    private BiFunction<Integer, Integer, Integer> calFunction;

    Operator(String sign ,BiFunction<Integer, Integer, Integer> calFunction) {
        this.sign = sign;
        this.calFunction = calFunction;
    }

    public static int calculate(String sign, int a, int b) {
        return calculate(sign).calFunction.apply(a, b);
    }

    public static Operator calculate(String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(SIGN_ERROR_MASSAGE));
    }
}