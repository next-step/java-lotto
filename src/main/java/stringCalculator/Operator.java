package stringCalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (firstOperand, secondOperand) -> firstOperand + secondOperand),
    SUBTRACT("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLY("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVIDE("/", (firstOperand, secondOperand) -> firstOperand / secondOperand);

    private String sign;
    private BiFunction<Integer, Integer, Integer> calculation;

    Operator(String sign, BiFunction<Integer, Integer, Integer> calculation) {
        this.sign = sign;
        this.calculation = calculation;
    }

    public static Operator of(String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("연산기호를 확인해주세요."));
    }

    public int calculate(int firstOperand, int secondOperand) {
        return calculation.apply(firstOperand, secondOperand);
    }

}
