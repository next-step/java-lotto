package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRanks {
    private final Map<LottoRank, Integer> ranks;

    public LottoRanks(Lottos lottos, List<Integer> winList, int bonus) {
        this.ranks = lottos.findRanks(winList, bonus);
    }

    public long findPrizeMoney() {
        long money = 0;
        for (LottoRank lottoRank : ranks.keySet()) {
            money = money + lottoRank.sumPrize(ranks.get(lottoRank));
        }
        return money;
    }

    public Map<LottoRank, Integer> find() {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            addMap(lottoRank, resultMap);
        }
        return resultMap;
    }

    private void addMap(LottoRank lottoRank, Map<LottoRank, Integer> resultMap) {
        if (lottoRank.matchCount(2)) {
            resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0));
        }
    }

    @Override
    public String toString() {
        return "LottoRanks{" +
                "ranks=" + ranks +
                '}';
    }
}
