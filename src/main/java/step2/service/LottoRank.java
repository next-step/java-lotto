package step2.service;

import step2.functional.Matchable;
import step2.functional.PrizeAmount;

import java.util.Map;

public enum LottoRank {

    FOURTH(3, mCnt -> mCnt == 3, nWinner -> nWinner * 5000),
    THIRD(4, mCnt -> mCnt == 4, nWinner -> nWinner * 50000),
    SECOND(5, mCnt -> mCnt == 5, nWinner -> nWinner * 1500000),
    FIRST(6, mCnt -> mCnt == 6, nWinner -> nWinner * 2000000000);

    private static final int LOTTO_PER_PRICE = 1000;

    private final int countOfMatch;

    private final Matchable matchable;

    private final PrizeAmount prizeAmount;

    LottoRank(int countOfMatch, Matchable matchable, PrizeAmount prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.matchable = matchable;
        this.prizeAmount = prizeAmount;
    }

    public static void getLottoNumber(Integer matchingCount, Map<LottoRank, Integer> winnerResults) {
        if (FOURTH.matchable.isMatch(matchingCount)) {
            winnerResults.compute(FOURTH, (k, v) -> v + 1);
        }
        if (THIRD.matchable.isMatch(matchingCount)) {
            winnerResults.compute(THIRD, (k, v) -> v + 1);
        }
        if (SECOND.matchable.isMatch(matchingCount)) {
            winnerResults.compute(SECOND, (k, v) -> v + 1);
        }
        if (FIRST.matchable.isMatch(matchingCount)) {
            winnerResults.compute(FIRST, (k, v) -> v + 1);
        }
    }

    public static double calculateRateOfReturn(int numOfLottoTicket, Map<LottoRank, Integer> winnerResults) {
        return (FOURTH.prizeAmount.getPrizeAmount(winnerResults.get(FOURTH))
                + THIRD.prizeAmount.getPrizeAmount(winnerResults.get(THIRD))
                + SECOND.prizeAmount.getPrizeAmount(winnerResults.get(SECOND))
                + FIRST.prizeAmount.getPrizeAmount(winnerResults.get(FIRST)))
                / (numOfLottoTicket * LOTTO_PER_PRICE);
    }
}
