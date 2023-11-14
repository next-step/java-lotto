package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorEnum {
    PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> firstNumber / secondNumber);

    private String operator;
    private BiFunction<Integer, Integer, Integer> function;
    OperatorEnum(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static int calculate(String operator, int firstNumber, int secondNumber) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.operator.equals(operator))
                .findFirst()
                .map(enumValue -> enumValue.function.apply(firstNumber, secondNumber))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported operator: " + operator));
    }

    public static boolean contains(String value) {
        return Arrays.stream(values())
                .anyMatch(operatorEnum -> operatorEnum.operator.equals(value));
    }

}
