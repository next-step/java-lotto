package edu.nextstep.camp.lotto.domain;

import java.util.Collection;

public class PurchaseList {
    public static final int GAME_PRICE = 1000;

    private final Lottos lottos;

    private PurchaseList(Lottos lottos) {
        this.lottos = lottos;
    }

    public static PurchaseList purchase(int budget, LottoGenerator generator) {
        if (budget < GAME_PRICE) {
            throw new IllegalArgumentException("invalid input: budget must be at least 1000, but " + budget);
        }

        if (budget % GAME_PRICE != 0) {
            throw new IllegalArgumentException("invalid input: budget must be multiple of 1000, but " + budget);
        }

        return new PurchaseList(generator.generate(budget / GAME_PRICE));
    }

    public int amount() {
        return lottos.amount();
    }

    public Collection<Lotto> collect() {
        return lottos.collect();
    }

    public GameResult winningResult(Lotto winningNumber) {
        return lottos.winningResult(winningNumber);
    }
}
