package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int purchaseAmount;
    private final Map<LottoRanking, Integer> prizeByRanking = new HashMap<>();

    public LottoResult(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void addRanking(LottoRanking ranking) {
        prizeByRanking.put(ranking, ranking.getPrize());
    }

    public double getYield() {
        int totalPrize = prizeByRanking.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return totalPrize * 1.0 / purchaseAmount;
    }
}
