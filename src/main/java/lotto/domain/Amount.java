package lotto.domain;

public class Amount {
    private final long value;

    public Amount(int value) {
        this.value = value;
    }

    public Amount(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    public float divide(long divisor) {
        return (float) value / divisor;
    }

    public float divide(Amount divisor) {
        return (float) value / divisor.value;
    }

    public long multiply(long multiplier) {
        return value * multiplier;
    }
}
