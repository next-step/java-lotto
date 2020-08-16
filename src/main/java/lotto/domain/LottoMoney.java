package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import utils.StringUtils;

public class LottoMoney {
    private static final int LOTTO_MONEY_DEFAULT_UNIT = 1_000;

    private int lottoMoney;

    public LottoMoney(int lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public static LottoMoney of(String money) {
        int lottoMoney = StringUtils.toNumber(money);
        validateMoneyUnit(lottoMoney);

        return new LottoMoney(lottoMoney);
    }

    private static void validateMoneyUnit(int lottoMoney) {
        if (lottoMoney % LOTTO_MONEY_DEFAULT_UNIT != 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_MONEY_UNIT);
        }
    }
}
