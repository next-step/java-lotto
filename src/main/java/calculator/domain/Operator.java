package calculator.domain;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum Operator {
    PLUS((a, b) -> a + b),
    MINUS((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> a / b),
    ;

    private final BiFunction<Integer, Integer, Integer> function;


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

    Operator(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }
}

