package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int purchaseAmount;
    private final Map<LottoRanking, Integer> countByRanking = new HashMap<>();
    private int totalPrize = 0;

    public LottoResult(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void addRanking(LottoRanking ranking) {
        countByRanking.put(ranking, countByRanking.getOrDefault(ranking, 0) + 1);
        totalPrize += ranking.getPrize();
    }

    public Map<LottoRanking, Integer> getPrizeByRanking() {
        return Collections.unmodifiableMap(countByRanking);
    }

    public double getYield() {
        return totalPrize * 1.0 / purchaseAmount;
    }
}
