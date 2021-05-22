package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoGameOptions.MAP_LOTTO_RESULT;

public class LottoResultPack {
    private Map<LottoResult, Integer> lottoResultPack;

    public LottoResultPack() {
        lottoResultPack = new HashMap<>();

        initEachResultCount();
    }

    private void initEachResultCount() {
        for (LottoResult result : MAP_LOTTO_RESULT.values()) {
            lottoResultPack.put(result, 0);
        }
    }

    public void put(LottoResult matchResult) {
        lottoResultPack.merge(matchResult, 1, Integer::sum);
    }

    public int countOf(LottoResult lottoResult) {
        return lottoResultPack.get(lottoResult);
    }

    public double calculateProfitRatio(LottoPurchaseBudget purchaseBudget) {
        return (double)sumOfProfit() / purchaseBudget.budget();
    }

    private int sumOfProfit() {
        int sum = 0;

        for (LottoResult result : MAP_LOTTO_RESULT.values()) {
            sum += result.profit() * lottoResultPack.get(result);
        }

        return sum;
    }

}
