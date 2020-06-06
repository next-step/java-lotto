package dev.dahye.lotto.domain;

public class LottoMoney {
    private static final int ZERO_VALUE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    public int getCountOfLotto() {
        return money / LOTTO_PRICE;
    }

    protected void validate(int money) {
        if (mustBePositiveNumber(money) || isNoRemainder(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }

    private boolean mustBePositiveNumber(int money) {
        return money <= ZERO_VALUE;
    }

    private boolean isNoRemainder(int money) {
        return money % LOTTO_PRICE != ZERO_VALUE;
    }
}
