package step2;

import java.util.Objects;

public class Amount {

    private int value;

    private Amount(int value) {
        this.value = value;
    }

    public static Amount of(int value) {
        return new Amount(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
