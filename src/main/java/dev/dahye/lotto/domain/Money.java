package dev.dahye.lotto.domain;

public class Money {
    private static final int ZERO_VALUE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }

    protected void validateMoney(int money) {
        if (validZeroValue(money) || isNoRemainder(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }

    private boolean validZeroValue(int money) {
        return money == ZERO_VALUE;
    }

    private boolean isNoRemainder(int money) {
        return money % LOTTO_PRICE != ZERO_VALUE;
    }
}
