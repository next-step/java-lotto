package lotto.domain;

import java.util.stream.IntStream;

public class Amount {
    private final int value;

    public Amount(int value) {
        assertAmountPositive(value);
        this.value = value;
    }

    private void assertAmountPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("수량은 음수가 될 수 없습니다.");
        }
    }

    public int value() {
        return this.value;
    }

    public IntStream range() {
        return IntStream.range(0, value);
    }
}
