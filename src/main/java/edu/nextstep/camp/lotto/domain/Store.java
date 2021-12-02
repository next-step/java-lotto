package edu.nextstep.camp.lotto.domain;

import java.util.Collection;

public class Store {
    private Store() {}

    public static Lottos purchase(int budget, LottoGenerator generator) {
        return generator.generate(Budget.of(budget).availableAmount());
    }

    public static Lottos purchase(int budget, Collection<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("invalid input: purchased list cannot be null.");
        }

        if (lottos.size() > Budget.of(budget).availableAmount()) {
            throw new IllegalArgumentException("invalid input: not enough money to purchase manually.");
        }

        return Lottos.of(lottos);
    }
}
