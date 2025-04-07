package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public LottoResult calculate(int purchaseAmount, List<Lotto> lottoList, LottoWinnings lottoWinnings) {
        Map<LottoPrize, Integer> lottoPrizes = new HashMap<>();
        for (Lotto lotto : lottoList) {
            LottoPrize lottoPrize = lottoWinnings.countMatches(lotto);
            lottoPrizes.put(lottoPrize, lottoPrizes.getOrDefault(lottoPrize, 0) + 1);
        }
        return new LottoResult(lottoPrizes, purchaseAmount);
    }

}