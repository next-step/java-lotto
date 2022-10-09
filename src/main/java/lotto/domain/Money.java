package lotto.domain;

import java.util.Objects;

public class Money {

    private final int value;

    public Money(final int value) {
        validateZeroOrMore(value);
        this.value = value;
    }


    public Money(final String stringValue) {
        this(parseInt(stringValue));
    }

    private void validateZeroOrMore(int value) {
        if (value < 0) {
            throw NotZeroOrMoreNumberException.of();
        }
    }

    private static int parseInt(String stringValue) {
        try {
            return Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.of();
        }
    }

    public boolean isThousandUnits() {
        return this.value % 1000 == 0;
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
