package lotto.model;

import common.model.Number;

import java.util.HashMap;
import java.util.Map;

public class LottoReport {

    private final Map<LottoRank, Number> lottoRankNumbers;

    public LottoReport() {
        this.lottoRankNumbers = new HashMap<>();
    }

    public void increaseCount(LottoRank rank) {
        Number count = lottoRankNumbers.getOrDefault(rank, new Number());
        count.plus();
        lottoRankNumbers.put(rank, count);
    }

    public float calculateRateOfRevenue(int purchaseAmount) {
        float revenue = 0;

        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = this.lottoRankNumbers.getOrDefault(rank, new Number());
            revenue += rank.getAmount() * count.getNumber();
        }

        return Math.round(revenue / purchaseAmount * 100) / 100.F;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = lottoRankNumbers.getOrDefault(rank, new Number());
            builder.append(rank.format(count)).append("\n");
        }
        return builder.toString();
    }
}
