package study.lotto.step1.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (firstOperand, secondOperand) -> firstOperand.value().add(secondOperand.value())),
    SUBTRACT("-", (firstOperand, secondOperand) -> firstOperand.value().subtract(secondOperand.value())),
    MULTIPLY("*", (firstOperand, secondOperand) -> firstOperand.value().multiply(secondOperand.value())),
    DIVIDE("/", divide());

    private final String sign;
    private final BiFunction<Operand, Operand, BigDecimal> calculation;

    Operator(String sign, BiFunction<Operand, Operand, BigDecimal> calculation) {
        this.sign = sign;
        this.calculation = calculation;
    }

    public Operand calculate(Operand firstOperand, Operand secondOperand) {
        return new Operand(calculation.apply(firstOperand, secondOperand));
    }

    public static Operator of(String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다: " + sign));
    }

    private static BiFunction<Operand, Operand, BigDecimal> divide() {
        return (firstOperand, secondOperand) -> {
            validateDivision(firstOperand, secondOperand);
            return firstOperand.value().divide(secondOperand.value(), 0, RoundingMode.HALF_UP);
        };
    }

    private static void validateDivision(Operand dividend, Operand divisor) {
        if(!isDivisible(dividend, divisor)) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다: "
                    + dividend.plainString() + "/" + divisor.plainString());
        }
    }

    private static boolean isDivisible(Operand dividend, Operand divisor) {
        return dividend.value().remainder(divisor.value()).compareTo(BigDecimal.ZERO) == 0;
    }
}
