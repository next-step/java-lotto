package lotto.domain.stat;

import java.util.Map;

public class LottoRankCountMap {

    private final Map<LottoRank, Integer> rankCountMap;

    public LottoRankCountMap(Map<LottoRank, Integer> rankCountMap) {
        this.rankCountMap = rankCountMap;
    }

    public int get(LottoRank key) {
        if (rankCountMap.containsKey(key)) {
            return rankCountMap.get(key);
        }

        return 0;
    }

}
