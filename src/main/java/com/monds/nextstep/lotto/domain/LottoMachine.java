package com.monds.nextstep.lotto.domain;

import static com.google.common.base.Preconditions.checkArgument;

public final class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final String MONEY_ERROR_MESSAGE = "money must be at least zero: %s";
    private static final String MONEY_UNIT_MESSAGE = "Only %s won units are allowed: %s";

    private LottoMachine() {}

    public static Lottos purchase(int money) {
        checkArgument(money > 0, MONEY_ERROR_MESSAGE, money);
        checkArgument(money % LOTTO_PRICE == 0, MONEY_UNIT_MESSAGE, LOTTO_PRICE, money);

        return new Lottos(money / LOTTO_PRICE);
    }

    public static int calculateHowMuch(int lottoCount) {
        return lottoCount * LOTTO_PRICE;
    }
}
