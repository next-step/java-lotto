package lotto.domain;

public class Amount {
    private final int value;

    public Amount(int value) {
        assertAmountPositive(value);
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    private void assertAmountPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("수량은 음수가 될 수 없습니다.");
        }
    }
}
