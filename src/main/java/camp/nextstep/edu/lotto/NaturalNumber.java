package camp.nextstep.edu.lotto;

import java.util.Objects;

public class NaturalNumber implements Comparable<NaturalNumber> {
    private static final int ZERO = 0;

    private final int value;

    private NaturalNumber(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("'value' must be greater than or equal to " + ZERO);
        }
        this.value = value;
    }

    public static NaturalNumber from(int value) {
        return new NaturalNumber(value);
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "NaturalNumber{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalNumber that = (NaturalNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(NaturalNumber naturalNumber) {
        if (naturalNumber == null) {
            throw new IllegalArgumentException("'naturalNumber' must not be null");
        }
        return Integer.compare(value, naturalNumber.value);
    }

    public NaturalNumber divideBy(NaturalNumber naturalNumber) {
        if (naturalNumber == null) {
            throw new IllegalArgumentException("'naturalNumber' must not be null");
        }
        final int quotient = value / naturalNumber.value;
        return new NaturalNumber(quotient);
    }
}
