package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public LottoResult calculate(int purchaseAmount, List<Lotto> lottoList, List<Integer> winningNumbers) {
        long totalPrize = 0;
        Map<Integer, Integer> matchCounts = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.countMatches(winningNumbers);
            long prize = LottoPrize.getPrizeByMatchCount(matchCount);
            totalPrize += prize;
            matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0) + 1);
        }
        double rate = (double) totalPrize / purchaseAmount;
        return new LottoResult(matchCounts, rate);
    }

}