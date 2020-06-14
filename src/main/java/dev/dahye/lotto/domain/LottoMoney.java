package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.DoubleUtils;

import java.math.BigDecimal;

public class LottoMoney {
    private static final int MIN_VALUE = 0;
    public static final int PRICE_PER_LOTTO = 1000;

    private final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    public int calculateCountOfLotto() {
        return money / PRICE_PER_LOTTO;
    }

    private void validate(int money) {
        if (isNegative(money) || isNoRemainder(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }

    private boolean isNegative(int money) {
        return money <= MIN_VALUE;
    }

    private boolean isNoRemainder(int money) {
        return money % PRICE_PER_LOTTO != MIN_VALUE;
    }

    public BigDecimal divideBy(LottoMoney lottoMoney) {
        return DoubleUtils.parseDoubleSecondDigit((double) lottoMoney.money / money);
    }
}
