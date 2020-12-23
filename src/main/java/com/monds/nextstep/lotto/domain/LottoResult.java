package com.monds.nextstep.lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoResult {

    private final int purchaseAmount;
    private final Map<LottoRanking, Integer> countByRanking;

    public LottoResult(int lottoCount, Map<LottoRanking, Integer> countByRanking) {
        purchaseAmount = Lottos.calculateHowMuch(lottoCount);
        this.countByRanking = countByRanking;
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
