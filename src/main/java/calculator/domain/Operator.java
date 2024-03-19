package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b),
    ;

    private final String sign;
    private final BinaryOperator<Integer> function;

    public static Operator findBySign(String operatorSign) {
        return Arrays.stream(values())
                .filter(type -> type.sign.equals(operatorSign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }


    public int operate(Integer a, Integer b) {
        assertNotNull(a);
        assertNotNull(b);

        return this.function.apply(a, b);
    }

    private void assertNotNull(Integer a) {
        if (a == null) {
            throw new IllegalArgumentException("계산기의 매개변수는 null일 수 없습니다.");
        }
    }

    Operator(String sign, BinaryOperator<Integer> function) {
        this.sign = sign;
        this.function = function;
    }
}

