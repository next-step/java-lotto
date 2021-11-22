package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lottos {
    private final Collection<Lotto> lottos;

    public static Lottos of(Collection<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("invalid input: lottos must not be null or empty");
        }

        return new Lottos(lottos);
    }

    private Lottos(Collection<Lotto> lottos) {
        this.lottos = Collections.unmodifiableCollection(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos others = (Lottos) o;
        return lottos.containsAll(others.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    public int amount() {
        return lottos.size();
    }

    public GameResult winningResult(Lotto winningNumber) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (Lotto lotto: lottos) {
            rankMap.compute(lotto.matchedCount(winningNumber), (k, v) -> v == null ? 1 : v++);
        }
        return GameResult.of(rankMap.getOrDefault(6, 0), rankMap.getOrDefault(5, 0),
                rankMap.getOrDefault(4, 0), rankMap.getOrDefault(3, 0));
    }
}
