package lotto.domain;

import static java.util.Collections.frequency;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Bank checkWinningNumber(Lotto winningNumber) {
        List<Rank> rankList = lottos.stream().map(lotto -> lotto.winningNumberCount(winningNumber))
            .map(Rank::valueOf)
            .collect(Collectors.toList());
        return new Bank(new EnumMap<>(getRankMap(rankList)));
    }

    private Map<Rank, Integer> getRankMap(List<Rank> ranks) {
        return Rank.stream()
            .collect(toMap(identity(), rank -> frequency(ranks, rank)
            ));
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
