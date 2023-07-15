package lotto.model;

import java.util.Objects;

public final class Count {

    private static final int ZERO = 0;
    private final int number;

    public Count(final String number) {
        valiedate(number);
        this.number = Integer.parseInt(number);
    }

    public Count(final int number) {
        validateNegative(number);
        this.number = number;
    }

    private void valiedate(final String number) {
        try {
            int value = Integer.parseInt(number);
            validateNegative(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 수는 숫자여야 합니다.");
        }
    }

    private static void validateNegative(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("입력된 수는 양수여야 합니다.");
        }
    }

    public int getCount() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count = (Count) o;
        return number == count.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Count{" +
            "number=" + number +
            '}';
    }
}
