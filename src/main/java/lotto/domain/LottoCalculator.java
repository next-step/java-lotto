package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public LottoResult calculate(int purchaseAmount, List<Lotto> lottoList, LottoWinnings lottoWinnings) {
        long totalWinningMoney = 0;
        Map<LottoPrize, Integer> lottoPrizes = new HashMap<>();
        for (Lotto lotto : lottoList) {
            LottoMatch lottoMatch = lottoWinnings.countMatches(lotto);
            LottoPrize lottoPrize = LottoPrize.from(lottoMatch);
            totalWinningMoney += lottoPrize.getWinningMoney();
            lottoPrizes.put(lottoPrize, lottoPrizes.getOrDefault(lottoPrize, 0) + 1);
        }
        double rate = (double) totalWinningMoney / purchaseAmount;
        return new LottoResult(lottoPrizes, rate);
    }

}