package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLICATION("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> num1 / num2);

    private final String text;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String text, BiFunction<Integer, Integer, Integer> function) {
        this.text = text;
        this.function = function;
    }

    private String getText() {
        return text;
    }

    public static Operator of(String text) {
        return Arrays.stream(values())
            .filter(operator -> operator.getText().equals(text))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int leftOperand, int rightOperand) {
        return function.apply(leftOperand, rightOperand);
    }
}
