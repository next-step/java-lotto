package calculator.domain;

import java.util.Arrays;

public enum Operator {

    ADD("+", Integer::sum),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", ((first, second) -> first / second));

    private static final String NOT_OPERATOR_MESSAGE = "연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.";

    private final String value;
    private final Operable operable;

    Operator(String value, Operable operable) {
        this.value = value;
        this.operable = operable;
    }

    public static Operator from(final String value) {
        return Arrays.stream(values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_OPERATOR_MESSAGE));
    }

    public int operate(int firstNumber, int secondNumber) {
        if (isDividedByZero(secondNumber)) {
            throw new IllegalArgumentException("'/'(나누기 연산자) 뒤의 숫자는 0일 수 없습니다.");
        }
        return operable.operate(firstNumber, secondNumber);
    }

    private boolean isDividedByZero(int secondNumber) {
        return DIVIDE.equals(this) && secondNumber <= 0;
    }
}
