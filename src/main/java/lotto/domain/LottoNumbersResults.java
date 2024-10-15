package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumbersResults {
    private final Map<LottoCashPrize, Integer> lottoNumbersResults;

    public LottoNumbersResults(Map<LottoCashPrize, Integer> lottoNumbersResults) {
        this.lottoNumbersResults = lottoNumbersResults;
    }

    public Map<LottoCashPrize, Integer> getValue() {
        return new HashMap<>(this.lottoNumbersResults);
    }

    public int sumCashPrizes() {
        int totalCashPrizes = 0;

        for (LottoCashPrize lottoCashPrize : LottoCashPrize.values()) {
            int cashPrize = lottoCashPrize.getPrize();
            Integer sheetMatchCount = this.lottoNumbersResults.getOrDefault(
                    lottoCashPrize,
                    0
            );
            totalCashPrizes += cashPrize * sheetMatchCount;
        }

        return totalCashPrizes;
    }
}
