package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(Lotto... lottos) {
        this.lottos = List.of(lottos);
    }

    public Map<Rank, Long> seekRankStatistics(Lotto winnerLotto, Bonus bonus) {
        Map<Rank, Long> rankResults = initRankResults();
        for (Lotto lotto : lottos) {
            Rank rank = findRankBy(winnerLotto, bonus, lotto);
            rankResults.put(rank, rankResults.get(rank) + 1);
        }
        return rankResults;
    }

    private Rank findRankBy(Lotto winnerLotto, Bonus bonus, Lotto lotto) {
        int countOfMatch = lotto.countOfMatch(winnerLotto);
        boolean containsBonus = lotto.containsBonus(bonus);
        return Rank.valeOf(countOfMatch, containsBonus);
    }

    private Map<Rank, Long> initRankResults() {
        Map<Rank, Long> rankResults = new LinkedHashMap<>();
        rankResults.put(NOTHING, 0L);
        rankResults.put(FIFTH, 0L);
        rankResults.put(FOURTH, 0L);
        rankResults.put(THIRD, 0L);
        rankResults.put(SECOND, 0L);
        rankResults.put(FIRST, 0L);
        return rankResults;
    }

    public List<Lotto> getLottos() {
        return lottos;
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

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
