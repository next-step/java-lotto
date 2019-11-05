package com.seok2.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final Money PRICE = Money.of(1_000);
    private static final LottoStrategy strategy = new RandomLottoStrategy();

    private LottoMachine() {

    }

    public static Ticket buy(Money investment) {

        Money purchaseAmount = Money.ZERO;
        List<Lotto> lotteries = new ArrayList<>();
        while (investment.moreThanOrEquals(PRICE)) {
            lotteries.add(Lotto.generate(strategy));
            investment = investment.minus(PRICE);
            purchaseAmount = purchaseAmount.add(PRICE);
        }
        return Ticket.of(purchaseAmount, Lotteries.of(lotteries));
    }
}
