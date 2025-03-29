package lotto.domain;

import java.util.List;

public class LottoCalculator {
    private static final int MATCH_COUNT_THREE = 3;
    private static final int MATCH_COUNT_FOUR = 4;
    private static final int MATCH_COUNT_FIVE = 5;
    private static final int MATCH_COUNT_SIX = 6;
    private static final long PRIZE_THREE = 5000;
    private static final long PRIZE_FOUR = 50000;
    private static final long PRIZE_FIVE = 1500000;
    private static final long PRIZE_SIX = 2000000000L;

    public LottoResult calculate(int purchaseAmount, List<Lotto> lottoList, List<Integer> winningNumbers) {
        long totalPrize = 0;
        int threeMatches = 0, fourMatches = 0, fiveMatches = 0, sixMatches = 0;
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.countMatches(winningNumbers);
            totalPrize += calculatePrize(matchCount);
            threeMatches += (matchCount == MATCH_COUNT_THREE) ? 1 : 0;
            fourMatches += (matchCount == MATCH_COUNT_FOUR) ? 1 : 0;
            fiveMatches += (matchCount == MATCH_COUNT_FIVE) ? 1 : 0;
            sixMatches += (matchCount == MATCH_COUNT_SIX) ? 1 : 0;
        }
        double rate = (double) totalPrize / purchaseAmount;
        return new LottoResult(threeMatches, fourMatches, fiveMatches, sixMatches, rate);
    }

    private long calculatePrize(int matchCount) {
        if (matchCount == MATCH_COUNT_THREE) return PRIZE_THREE;
        if (matchCount == MATCH_COUNT_FOUR) return PRIZE_FOUR;
        if (matchCount == MATCH_COUNT_FIVE) return PRIZE_FIVE;
        if (matchCount == MATCH_COUNT_SIX) return PRIZE_SIX;
        return 0;
    }

}