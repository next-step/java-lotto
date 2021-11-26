package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
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
        List<Rank> ranks = new ArrayList<>(lottos.size());
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.matchedCount(winningNumber);
            ranks.add(Rank.valueOf(matchedCount));
        }
        return GameResult.of(Ranks.of(ranks));
    }
}
