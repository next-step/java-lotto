package lotto.domain;

import java.util.Map;

public class LottoWinningRecord {

    Map<LottoRank, Integer> lottoRankMap;

    LottoWinningRecord(Map<LottoRank, Integer> lottoRankMap) {
        this.lottoRankMap = lottoRankMap;
    }

    public float totalLottoPrizeAmount() {
        long total = lottoRankMap.keySet()
                .stream()
                .mapToLong( key -> {
                    int count = lottoRankMap.get(key);
                    return key.money() * count;
                })
                .sum();
        return total;
    }

    public Map<LottoRank, Integer> lottoRankMap() {
        return lottoRankMap;
    }
}
