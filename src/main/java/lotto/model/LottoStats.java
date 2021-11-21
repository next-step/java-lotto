package lotto.model;

import common.model.Number;

import java.util.HashMap;
import java.util.Map;

public class LottoStats {

    private final Map<LottoRank, Number> lottoRankNumberMap;
    private final int purchaseAmount;
    private float rateOfRevenue;

    public LottoStats(Lotto lotto, int purchaseAmount) {
        lottoRankNumberMap = convert(lotto);
        this.purchaseAmount = purchaseAmount;
        calculateRateOfRevenue();
    }

    //TEST
    public LottoStats(Map<LottoRank, Number> lottoRankNumberMap, int purchaseAmount) {
        this.lottoRankNumberMap = lottoRankNumberMap;
        this.purchaseAmount = purchaseAmount;
        calculateRateOfRevenue();
    }

    private Map<LottoRank, Number> convert(Lotto lotto) {
        Map<LottoRank, Number> lottoRankNumberMap = new HashMap<>();
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            LottoRank rank = lottoNumbers.getLottoRank();
            Number value = lottoRankNumberMap.getOrDefault(rank, new Number());
            value.plus();
            lottoRankNumberMap.put(rank, value);
        }
        return lottoRankNumberMap;
    }

    private void calculateRateOfRevenue() {
        float revenue = 0;

        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = lottoRankNumberMap.getOrDefault(rank, new Number());
            revenue += rank.getAmount() * count.getNumber();
        }

        this.rateOfRevenue = Math.round(revenue / purchaseAmount * 100) / 100.0F;
    }

    public Map<LottoRank, Number> getLottoRankNumberMap() {
        return lottoRankNumberMap;
    }

    public float getPurchaseAmount() {
        return purchaseAmount;
    }

    public float getRateOfRevenue() {
        return rateOfRevenue;
    }
}




