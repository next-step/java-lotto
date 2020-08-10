package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRanking, Integer> rankingMap = new HashMap<>();
    private int totalPrize = 0;

    public void addRanking(LottoRanking lottoRanking) {
        rankingMap.put(lottoRanking, rankingMap.getOrDefault(lottoRanking, 0) + 1);
        totalPrize += lottoRanking.prize();
    }

    public Map<LottoRanking, Integer> getRankingMap() {
        return Collections.unmodifiableMap(rankingMap);
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
