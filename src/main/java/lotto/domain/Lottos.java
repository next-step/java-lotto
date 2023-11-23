package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> lottos) {
        this.lottos = lottos.stream().map(Lotto::new).collect(Collectors.toList());
    }

    public Lottos(Lotto... lottos) {
        this.lottos = List.of(lottos);
    }

    public Map<Rank, Long> seekStatistics(Lotto winnerLotto) {
        Map<Rank, Long> rankResults = new LinkedHashMap<>();
        for (Lotto lotto : lottos) {
            int countOfMatch = lotto.countOfMatch(winnerLotto);
            Rank rank = Rank.valeOf(countOfMatch);
            rankResults.put(rank, rankResults.getOrDefault(rank, 0L) + 1);
        }
        return rankResults;
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
