package edu.nextstep.camp.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<List<String>> collect() {
        return lottos.collect()
                .stream()
                .map(lotto -> lotto.collect()
                        .stream()
                        .map(LottoNumber::toString)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public GameResult winningResult(Lotto winningNumber) {
        return lottos.winningResult(winningNumber);
    }
}
