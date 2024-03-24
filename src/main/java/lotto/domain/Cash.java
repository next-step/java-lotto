package lotto.domain;

public class Cash {
    private final int value;

    public Cash(int cash) {
        assertCashPositive(cash);
        this.value = cash;
    }

    private void assertCashPositive(int cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("현금은 마이너스 통장이 아닙니다.");
        }
    }

    public int value() {
        return this.value;
    }

    public int buyableAmount(int price) {
        return value / price;
    }
}
