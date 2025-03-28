package lotto.domain;

public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    public int divide(int divisor) {
        return value / divisor;
    }
}
