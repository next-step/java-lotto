package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoRank.MAP_LOTTO_RANK;

public class LottoResultPack {
    private Map<LottoRank, Integer> lottoResultPack;

    public LottoResultPack() {
        lottoResultPack = new HashMap<>();

        initEachResultCount();
    }

    private void initEachResultCount() {
        for (LottoRank result : MAP_LOTTO_RANK.values()) {
            lottoResultPack.put(result, 0);
        }
    }

    public void put(LottoRank matchResult) {
        lottoResultPack.merge(matchResult, 1, Integer::sum);
    }

    public int countOf(LottoRank lottoResult) {
        return lottoResultPack.get(lottoResult);
    }

    public double calculateProfitRatio(LottoPurchaseBudget purchaseBudget) {
        return (double)sumOfProfit() / purchaseBudget.budget();
    }

    private int sumOfProfit() {
        int sum = 0;

        for (LottoRank result : MAP_LOTTO_RANK.values()) {
            sum += result.profit() * lottoResultPack.get(result);
        }

        return sum;
    }

}
