package lottery;

import java.util.Objects;

public class Natural implements Comparable<Natural> {
    private final int value;

    public Natural(int amount) {
        checkAmountIsZeroOrPositive(amount);
        this.value = amount;
    }

    public int value() {
        return value;
    }

    private void checkAmountIsZeroOrPositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount given");
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
        var amount = (Natural) object;
        return Objects.equals(this.value, amount.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Natural other) {
        return Integer.compare(value, other.value);
    }
}
