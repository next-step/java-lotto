package calculator.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (number1, number2) -> new Number(number1.getNumber() + number2.getNumber())),
    MINUS("-", (number1, number2) -> new Number(number1.getNumber() - number2.getNumber())),
    DIVIDE("/", (number1, number2) -> {
        try {
            return new Number(number1.getNumber() / number2.getNumber());
        } catch (ArithmeticException arithmeticException) {
            return new Number(0);
        }
    }),
    MULTIPLE("*", (number1, number2) -> {
        try {
            return new Number(number1.getNumber() * number2.getNumber());
        } catch (ArithmeticException arithmeticException) {
            return new Number(0);
        }
    });

    private final String operator;
    private final BiFunction<Number, Number, Number> function;

    Operator(String operator, BiFunction<Number, Number, Number> function) {
        this.operator = operator;
        this.function = function;
    }

    public static Operator create(String operator) {
        return Arrays.stream(values())
                .filter(operatorEnum -> operatorEnum.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 잘못된 연산자입니다.", operator)));
    }

    public Number calculate(Number number1, Number number2) {
        return function.apply(number1, number2);
    }
}
