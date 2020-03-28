package Calculator;

import java.util.Objects;

public class NonNegativeNumber {
    static public final NonNegativeNumber ZERO = new NonNegativeNumber(0);

    private final int number;

    public NonNegativeNumber(int number) {
        validateNumberNegative(number);
        this.number = number;
    }

    private void validateNumberNegative(final int number) {
        if (number < 0) {
            throw new RuntimeException("Not Allowed Negative Number");
        }
    }

    NonNegativeNumber add(final NonNegativeNumber otherNumber) {
        return new NonNegativeNumber(number + otherNumber.getNumber());
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonNegativeNumber that = (NonNegativeNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
