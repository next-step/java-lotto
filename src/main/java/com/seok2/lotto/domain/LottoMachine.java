package com.seok2.lotto.domain;

import static com.seok2.lotto.domain.Lotto.PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final LottoStrategy strategy = new RandomLottoStrategy();

    private LottoMachine() {
    }

    public static Lotteries buy(Money investment, Papers papers) {
        return Lotteries.of(getLotteries(investment, papers));
    }

    private static List<Lotto> getLotteries(Money investment, Papers papers) {
        List<Lotto> lotteries = new ArrayList<>();
        while (investment.moreThanOrEquals(PRICE)) {
            lotteries.add(generate(papers));
            investment = investment.minus(PRICE);
        }
        return lotteries;
    }

    private static Lotto generate(Papers papers) {
        if (papers.isNotEmpty()) {
            return Lotto.generate(papers.next());
        }
        return Lotto.generate(strategy);

    }
}
