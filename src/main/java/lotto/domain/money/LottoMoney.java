package lotto.domain.money;

import java.math.BigDecimal;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoMoney {
    private final BigDecimal money;

    private LottoMoney(int money) {
        this.money = validate(money);
    }

    public static LottoMoney of(int lottoMoney) {
        return new LottoMoney(lottoMoney);
    }

    public static LottoMoney of(BigDecimal lottoMoney) {
        return new LottoMoney(lottoMoney.intValue());
    }

    public BigDecimal validate(int money) {
        if (money < PRICE_PER_GAME) {
            throw new NotEnoughMoneyException();
        }
        return new BigDecimal(money);
    }

    public int getAvailableBuyingCount() {
        return Math.floorDiv(money.intValue(), PRICE_PER_GAME);
    }

    public LottoMoney remainsMoney(int size) {
        if (getAvailableBuyingCount() < size) {
            throw new NotAffordableMoneyException();
        }
        return LottoMoney.of(money.subtract(BigDecimal.valueOf(PRICE_PER_GAME * size)));
    }
}
