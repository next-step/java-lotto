package lotto.domain.stat;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoRankCountMap {

    private final Map<LottoRank, Integer> rankCountMap;

    private LottoRankCountMap(Map<LottoRank, Integer> rankCountMap) {
        this.rankCountMap = rankCountMap;
    }

    public static LottoRankCountMap create(Lottos lottos, Lotto winningLotto) {
        Collection<Lotto> lottoCollection = lottos.collect();

        Map<LottoRank, Integer> rankCountMap =  lottoCollection.stream()
                .map(lotto -> lotto.calculateRank(winningLotto))
                .filter(LottoRank::isNotNone)
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.reducing(0, e -> 1, Integer::sum)
                ));

        return new LottoRankCountMap(rankCountMap);
    }

    public int get(LottoRank key) {
        if (rankCountMap.containsKey(key)) {
            return rankCountMap.get(key);
        }

        return 0;
    }

}
