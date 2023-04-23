package calculator.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum OperatorType {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String character;
    private Comparator<Integer> expression;

    OperatorType(String character, Comparator<Integer> expression) {
        this.character = character;
        this.expression = expression;
    }

    public String character() {
        return character;
    }

    public static OperatorType of(String character) {
        return Arrays.stream(values())
                .filter(v -> character.equals(v.character))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산 기호가 아닙니다.", character)));
    }

    public int calculate(Number num1, Number num2) {
        return expression.compare(num1.intValue(), num2.intValue());
    }
}
