package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Store {
    private Store() {}

    public static Lottos purchase(Budget budget, LottoGenerator generator) {
        if (budget.exhausted()) {
            return Lottos.empty();
        }

        return generator.generate(budget.availableAmount());
    }

    public static Lottos purchase(Budget budget, Collection<Set<Integer>> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("invalid input: purchased list cannot be null.");
        }

        if (!budget.available(lottos.size())) {
            throw new IllegalArgumentException("invalid input: not enough money to purchase manually.");
        }

        return Lottos.of(lottos.stream()
                .map(Lotto::fromIntegers)
                .collect(Collectors.toList()));
    }
}
