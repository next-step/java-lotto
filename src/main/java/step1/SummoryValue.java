package step1;

import java.util.Objects;

public class SummoryValue {
    public static final int INIT_VALUE = 0;
    private int value;

    public SummoryValue() {
        this(INIT_VALUE);
    }

    public SummoryValue(int value) {
        isNotNegative(value);
        this.value = value;
    }

    private void isNotNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummoryValue that = (SummoryValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
