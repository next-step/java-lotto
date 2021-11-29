package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return lottos.containsAll(others.lottos) && others.lottos.containsAll(lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    public int amount() {
        return lottos.size();
    }

    public List<List<String>> collect() {
        return lottos.stream()
                .map(Lotto::collect)
                .collect(Collectors.toUnmodifiableList());
    }

    public GameResult winningResult(Lotto winningNumber, LottoNumber bonus) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("invalid input: winning number and bonus number must be exclusive");
        }

        List<Rank> ranks = new ArrayList<>(lottos.size());
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.matchedCount(winningNumber);
            ranks.add(Rank.valueOf(matchedCount, lotto.contains(bonus)));
        }
        return GameResult.of(Ranks.of(ranks));
    }
}
