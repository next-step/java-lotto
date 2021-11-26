package lotto;

import java.util.Objects;

public class Money {
    public static final int ZERO = 0;

    private final int value;

    /*
        CONSTRUCTOR
     */
    public Money(int value) {
        validateGreaterThanEqualToZero(value);

        this.value = value;
    }

    /*
        INTERFACE
     */
    public int quotient(Money other) {
        validateNotEqualToZero(other);

        return this.value / other.value;
    }

    public Money subtract(Money other) {
        return new Money(this.value - other.value);
    }

    /*
        FUNCTION
     */
    private void validateGreaterThanEqualToZero(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("돈은 음수의 상태를 가질 수 없습니다.");
        }
    }

    private void validateNotEqualToZero(Money money) {
        if (money.value == ZERO) {
            throw new IllegalArgumentException("나누는 값은 0이 될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
