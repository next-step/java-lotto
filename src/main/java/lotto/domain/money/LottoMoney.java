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

    private BigDecimal validate(int money) {
        if (money < PRICE_PER_GAME) {
            throw new NotEnoughMoneyException();
        }
        return new BigDecimal(money);
    }

    public int getAvailableCount(int boughtCount) {
        int availableCount = Math.floorDiv(money.intValue(), PRICE_PER_GAME);
        if (availableCount < boughtCount) {
            throw new NotAffordableMoneyException();
        }
        return availableCount - boughtCount;
    }
}
