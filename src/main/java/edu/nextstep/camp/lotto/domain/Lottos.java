package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lottos {
    private static final int MATCHED_COUNT_1ST = 6;
    private static final int MATCHED_COUNT_2ND = 5;
    private static final int MATCHED_COUNT_3RD = 4;
    private static final int MATCHED_COUNT_4TH = 3;
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;

    private final Collection<Lotto> lottos;

    private Lottos(Collection<Lotto> lottos) {
        this.lottos = Collections.unmodifiableCollection(lottos);
    }

    public static Lottos of(Collection<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("invalid input: lottos must not be null or empty");
        }

        return new Lottos(lottos);
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

    public Collection<Lotto> collect() {
        return lottos;
    }

    public GameResult winningResult(Lotto winningNumber) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            rankMap.compute(
                    lotto.matchedCount(winningNumber), (k, v) -> v == null ? INCREASE_COUNT : v + INCREASE_COUNT
            );
        }
        return GameResult.of(
                rankMap.getOrDefault(MATCHED_COUNT_1ST, INITIAL_COUNT),
                rankMap.getOrDefault(MATCHED_COUNT_2ND, INITIAL_COUNT),
                rankMap.getOrDefault(MATCHED_COUNT_3RD, INITIAL_COUNT),
                rankMap.getOrDefault(MATCHED_COUNT_4TH, INITIAL_COUNT));
    }
}
