package com.seok2.lotto.domain;

import static com.seok2.lotto.domain.Lotto.PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final LottoStrategy strategy = new RandomLottoStrategy();

    private LottoMachine() {

    }

    public static Lotteries buy(Money investment) {
        Money purchaseAmount = Money.ZERO;
        List<Lotto> lotteries = new ArrayList<>();
        while (investment.moreThanOrEquals(PRICE)) {
            lotteries.add(Lotto.generate(strategy));
            investment = investment.minus(PRICE);
            purchaseAmount = purchaseAmount.add(PRICE);
        }
        return Lotteries.of(lotteries);
    }
}
