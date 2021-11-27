package lotto.model;

import common.model.Number;

import java.util.Map;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static Lotto ticket(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        return new Lotto(count);
    }

    public static float calculateRateOfRevenue(Map<LottoRank, Number> lottoRankNumbers, int purchaseAmount) {
        float revenue = 0;

        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = lottoRankNumbers.getOrDefault(rank, new Number());
            revenue += rank.getAmount() * count.getNumber();
        }

        return Math.round(revenue / purchaseAmount * 100) / 100.F;
    }
}
