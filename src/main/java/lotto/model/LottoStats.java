package lotto.model;

import common.model.Number;

import java.util.HashMap;
import java.util.Map;

public class LottoStats {

    private final Map<LottoRank, Number> lottoRankNumberMap;
    private final int purchaseAmount;

    public LottoStats(Lotto lotto, int purchaseAmount) {
        lottoRankNumberMap = new HashMap<>();
        this.purchaseAmount = purchaseAmount;
    }

    //TEST
    public LottoStats(Map<LottoRank, Number> lottoRankNumberMap, int purchaseAmount) {
        this.lottoRankNumberMap = lottoRankNumberMap;
        this.purchaseAmount = purchaseAmount;
    }

    public float calculateRateOfRevenue(float revenue) {
        return Math.round(revenue / purchaseAmount * 100) / 100.0F;
    }

    public Map<LottoRank, Number> getLottoRankNumberMap() {
        return lottoRankNumberMap;
    }

    public float getPurchaseAmount() {
        return purchaseAmount;
    }
}




