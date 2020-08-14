package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int purchasePrice;
    private final Map<LottoRanking, Integer> rankingMap = new HashMap<>();
    private long totalPrize = 0;

    public LottoResult(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void addRanking(LottoRanking lottoRanking) {
        rankingMap.put(lottoRanking, rankingMap.getOrDefault(lottoRanking, 0) + 1);
        totalPrize += lottoRanking.prize();
    }

    public Map<LottoRanking, Integer> getRankingMap() {
        return Collections.unmodifiableMap(rankingMap);
    }

    public double getSaveOfReturn() {
        return totalPrize * 1.0 / purchasePrice;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
