package step03.domain;

import step03.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Integer size() {
        return lottos.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    public Map<Rank, Integer> calculateCountOfMatch(Lotto targetLotto, LottoBall bonusBall) {
        Map<Rank, Integer> rank = new HashMap<>();
        lottos.forEach(lotto -> {
            Integer matchOfCount = lotto.matchCount(targetLotto);
            Rank target = Rank.valueOf(matchOfCount, lotto.isContaining(bonusBall));
            rank.put(target, rank.getOrDefault(target, 0) + 1);
        });
        return rank;
    }
}
