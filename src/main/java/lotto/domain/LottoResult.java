package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoResult {

    private final int purchaseAmount;
    private final Map<LottoRanking, Integer> countByRanking = new HashMap<>();

    public LottoResult(int lottoCount) {
        purchaseAmount = LottoMachine.calculateHowMuch(lottoCount);
    }

    public void addRanking(LottoRanking ranking) {
        countByRanking.put(ranking, countByRanking.getOrDefault(ranking, 0) + 1);
    }

    public Map<LottoRanking, Integer> getPrizeByRanking() {
        return Collections.unmodifiableMap(countByRanking);
    }

    public double calculateYield() {
        return getTotalPrize() * 1.0 / purchaseAmount;
    }

    private int getTotalPrize() {
        final AtomicInteger totalPrize = new AtomicInteger();
        countByRanking.forEach((ranking, count) -> totalPrize.addAndGet(ranking.getPrize() * count));
        return totalPrize.get();
    }
}
