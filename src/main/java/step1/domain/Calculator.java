package step1.domain;

public class Calculator {
    public Number add(Number left, Number right) {
        return new Number(left.value() + right.value());
    }

    public Number subtract(Number left, Number right) {
        return new Number(left.value() - right.value());
    }

    public Number multiply(Number left, Number right) {
        return new Number(left.value() * right.value());
    }

    public Number divide(Number left, Number right) {
        if (right.value() == 0)
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return new Number(left.value() / right.value());
    }
}
