package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private static final Lottos emptyLottos = new Lottos(Collections.emptyList());

    private final Collection<Lotto> lottos;

    private Lottos(Collection<Lotto> lottos) {
        this.lottos = Collections.unmodifiableCollection(lottos);
    }

    public static Lottos of(Collection<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("invalid input: lottos must not be null");
        }

        if (lottos.isEmpty()) {
            return emptyLottos;
        }

        return new Lottos(lottos);
    }

    public static Lottos empty() {
        return emptyLottos;
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

    public Collection<Lotto> collect() {
        return lottos;
    }

    public GameResult winningResult(WinningNumber winningNumber) {
        final List<Rank> ranks = lottos.stream()
                .map(winningNumber::rank)
                .collect(Collectors.toUnmodifiableList());
        return GameResult.of(ranks);
    }
}
