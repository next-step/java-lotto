package domain;

import static domain.Lotto.PRICE_PER_ONE;

public class Amount {
    private int value;

    public Amount(int amount) {
        if (value < 0) {
            throw new IllegalArgumentException("Amount 는 음수일 수 없습니다.");
        }

        this.value = amount;
    }

    public int getBuyCount() {
        return value / PRICE_PER_ONE;
    }

    public int getValue() {
        return this.value;
    }
}
