package lotto.domain;

public class Amount {
    private final long value;

    public Amount(long value) {
        this.value = value;
    }

    public long divide(long divisor) {
        return value / divisor;
    }
}
