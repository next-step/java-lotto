package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> findRanks(List<Integer> winList, int bonus) {
        Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.findRank(winList, bonus);
            ranks.put(lottoRank, ranks.getOrDefault(lottoRank, 0) + 1);
        }

        return ranks;
    }

    public List<Lotto> find() {
        return Collections.unmodifiableList(lottos);
    }


}
