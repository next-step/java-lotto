package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    Sum("+", (num1, num2) -> num1 + num2),
    Subtraction("-", (num1, num2) -> num1 - num2),
    Multiplication("*", (num1, num2) -> num1 * num2),
    Division("/", (num1, num2) -> (int) num1 / num2);

    private final String calculation;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(String calculation, BiFunction<Integer, Integer, Integer> calculate) {
        this.calculation = calculation;
        this.calculate = calculate;
    }

    public int calculate(int operand1, int operand2) {
        try {
            calculate.apply(operand1, operand2);
        } catch (Exception e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return calculate.apply(operand1, operand2);
    }

    public static Operator find(String calculation) {
        return Arrays.stream(Operator.values())
                .filter(calculationMethod2 -> calculationMethod2.calculation.equals(calculation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("+, -, *, / 중 하나여야 합니다!"));
    }
}
