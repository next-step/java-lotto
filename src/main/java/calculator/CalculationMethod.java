package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculationMethod {

    Sum("+", (num1, num2) -> Integer.parseInt(num1) + Integer.parseInt(num2)),
    Subtraction("-", (num1, num2) -> Integer.parseInt(num1) - Integer.parseInt(num2)),
    Multiplication("*", (num1, num2) -> Integer.parseInt(num1) * Integer.parseInt(num2)),
    Division("/", (num1, num2) -> (int)Integer.parseInt(num1) / Integer.parseInt(num2));

    private final String calculation;
    private final BiFunction<String, String, Integer> calculate;

    CalculationMethod(String calculation, BiFunction<String, String, Integer> calculate) {
        this.calculation = calculation;
        this.calculate = calculate;
    }

    public int calculate(String num1, String num2) {
        try {
            calculate.apply(num1, num2);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return calculate.apply(num1, num2);
    }

    public static CalculationMethod find(String calculation) {
        return Arrays.stream(CalculationMethod.values())
                    .filter(calculationMethod2 -> calculationMethod2.calculation.equals(calculation))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("+, -, *, / 중 하나여야 합니다!"));

    }
}
