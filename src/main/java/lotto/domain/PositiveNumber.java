package lotto.domain;

import java.util.Objects;

public class PositiveNumber implements Comparable<PositiveNumber> {
    private int positiveNumber;

    public PositiveNumber(String value) {
        this(Parser.parseNumberFormat(value));
    }

    public PositiveNumber(int value) {
        negativeCheck(value);
        this.positiveNumber = value;
    }

    public boolean isZero() {
        if (positiveNumber == 0) {
            return true;
        }
        return false;
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }

    private void negativeCheck(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("숫자가 음수이면 안됩니다.");
        }
    }
    @Override
    public int compareTo(PositiveNumber other) {
        return Integer.compare(this.positiveNumber, other.positiveNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(positiveNumber);
    }
}
