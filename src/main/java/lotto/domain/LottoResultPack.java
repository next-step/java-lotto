package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static lotto.domain.LottoGameOptions.MAP_LOTTO_RESULT;

public class LottoResultPack {
    private Map<LottoResult, Integer> lottoResultPack;

    public LottoResultPack() {
        lottoResultPack = new HashMap<>();

        initEachResultCount();
    }

    private void initEachResultCount() {
        Set<Integer> set = MAP_LOTTO_RESULT.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            lottoResultPack.put(MAP_LOTTO_RESULT.get(it.next()), 0);
        }
    }

    public void put(LottoResult matchResult) {
        lottoResultPack.merge(matchResult, 1, Integer::sum);
    }

    public int countOf(LottoResult lottoResult) {
        return lottoResultPack.get(lottoResult);
    }

    public double calculateProfitRatio(LottoPurchaseBudget purchaseBudget) {
        return (double)purchaseBudget.budget() / sumOfProfit();
    }

    private int sumOfProfit() {
        int sum = 0;

        Set<Integer> set = MAP_LOTTO_RESULT.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            LottoResult result = MAP_LOTTO_RESULT.get(it.next());
            sum += result.profit() * lottoResultPack.get(result);
        }

        return sum;
    }

}
