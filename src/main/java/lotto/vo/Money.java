package lotto.vo;

import java.util.Objects;

public class Money {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String ZERO_EXCEPTION_MESSAGE = "입력 값은 영보다 작을 수 없습니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";

    private final long value;

    private Money(long value) {
        this.value = value;
    }

    public static Money create(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }

        int value = Integer.parseInt(input);

        if (value < 0) {
            throw new IllegalArgumentException(ZERO_EXCEPTION_MESSAGE);
        }
        return new Money(value);
    }

    public static Money create(long value) {
        return new Money(value);
    }

    public long getNumberToBuy(Money price) {
        return this.value / price.value;
    }

    public Money add(Money o) {
        return new Money(this.value + o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean lessThan(Money o) {
        return this.value < o.value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
