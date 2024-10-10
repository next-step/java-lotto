package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private Map<LottoRank, Integer> prizeCountMap;

    public static LottoStatistics createEmpty() {
        Map<LottoRank, Integer> prizeCountMap = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            prizeCountMap.put(lottoRank, 0);
        }

        return new LottoStatistics(prizeCountMap);
    }

    public LottoStatistics(Map<LottoRank, Integer> prizeCountMap) {
        this.prizeCountMap = prizeCountMap;
    }

    public void plusCount(LottoRank lottoRank) {
        Integer count = prizeCountMap.get(lottoRank);
        prizeCountMap.put(lottoRank, count + 1);
    }

    public int getCount(LottoRank lottoRank) {
        return prizeCountMap.get(lottoRank);
    }
}
