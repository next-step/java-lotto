package lotto.domain;

import lotto.domain.stat.LottoRank;
import lotto.domain.stat.LottoRankCountMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Collection<Lotto> collect() {
        return lottos;
    }

    public LottoRankCountMap lottoRankCountMap(Lotto winningLotto) {
        Map<LottoRank, Integer> rankCountMap =  lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto))
                .filter(LottoRank::isNotNone)
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.reducing(0, e -> 1, Integer::sum)
                ));

        return new LottoRankCountMap(rankCountMap);
    }

}
