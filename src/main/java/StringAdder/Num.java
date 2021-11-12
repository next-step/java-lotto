package StringAdder;

import java.util.Objects;

public class Num {
    private final int MINIMUM_VALUE = 0;

    private int value;

    public Num(int value) {
        checkNumberIsAboveZero(value);

        this.value = value;
    }

    public Num(String rawValue) {
        int value = extractNumberFromRawValue(rawValue);
        checkNumberIsAboveZero(value);

        this.value = value;
    }

    public Num add(Num other) {
        return new Num(this.value + other.value);
    }

    private int extractNumberFromRawValue(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (Exception e) {
            throw new RuntimeException("Input is not number.");
        }
    }

    private void checkNumberIsAboveZero(int value) {
        if (value < MINIMUM_VALUE) {
            throw new RuntimeException("Input is below zero.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Num num = (Num) object;

        return value == num.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
