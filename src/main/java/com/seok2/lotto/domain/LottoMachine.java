package com.seok2.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final Money LOTTO_PRICE = Money.of(1_000);
    private static final LottoStrategy strategy = new RandomLottoStrategy();

    public static Lotteries buy(Money investment) {
        List<Lotto> lotteries = new ArrayList<>();
        while (investment.moreThanOrEquals(LOTTO_PRICE)) {
            lotteries.add(Lotto.generate(strategy));
            investment = investment.minus(LOTTO_PRICE);
        }
        return new Lotteries(lotteries);
    }
}
