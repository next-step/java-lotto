package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import utils.StringUtils;

public class LottoMoney {
    public static final int DEFAULT_LOTTO_MONEY_UNIT = 1_000;

    private int lottoMoney;

    private LottoMoney(int lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public static LottoMoney of(String money) {
        int lottoMoney = StringUtils.toNumber(money);
        validateMoneyUnit(lottoMoney);

        return new LottoMoney(lottoMoney);
    }

    private static void validateMoneyUnit(int lottoMoney) {
        if (lottoMoney % DEFAULT_LOTTO_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_MONEY_UNIT);
        }
    }

    public int getBuyCount() {
        return lottoMoney / DEFAULT_LOTTO_MONEY_UNIT;
    }
}
