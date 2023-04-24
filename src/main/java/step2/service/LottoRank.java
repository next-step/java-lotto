package step2.service;

import step2.functional.Matchable;
import step2.functional.PrizeAmount;

import java.util.Map;

public enum LottoRank {

    MATCH_THREE(3, mCnt -> mCnt == 3, nWinner -> nWinner * 5000),
    MATCH_FOUR(4, mCnt -> mCnt == 4, nWinner -> nWinner * 50000),
    MATCH_FIVE(5, mCnt -> mCnt == 5, nWinner -> nWinner * 1500000),
    MATCH_SIX(6, mCnt -> mCnt == 6, nWinner -> nWinner * 2000000000);

    private static final int LOTTO_PER_PRICE = 1000;

    private final int countOfMatch;

    private final Matchable matchable;

    private final PrizeAmount prizeAmount;

    LottoRank(int countOfMatch, Matchable matchable, PrizeAmount prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.matchable = matchable;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank getLottoNumber(Integer matchingCount) {
        if (MATCH_THREE.matchable.isMatch(matchingCount)) {
            return MATCH_THREE;
        }
        if (MATCH_FOUR.matchable.isMatch(matchingCount)) {
            return MATCH_FOUR;
        }
        if (MATCH_FIVE.matchable.isMatch(matchingCount)) {
            return MATCH_FIVE;
        }
        if (MATCH_SIX.matchable.isMatch(matchingCount)) {
            return MATCH_SIX;
        }
        throw new IllegalArgumentException("맞춘 로또 번호 갯수는 당첨 범위가 아닙니다.");
    }

    public static double calculateRateOfReturn(int numOfLottoTicket, Map<LottoRank, Integer> winnerResults) {
        return (MATCH_THREE.prizeAmount.getPrizeAmount(winnerResults.get(MATCH_THREE))
                + MATCH_FOUR.prizeAmount.getPrizeAmount(winnerResults.get(MATCH_FOUR))
                + MATCH_FIVE.prizeAmount.getPrizeAmount(winnerResults.get(MATCH_FIVE))
                + MATCH_SIX.prizeAmount.getPrizeAmount(winnerResults.get(MATCH_SIX)))
                / (numOfLottoTicket * LOTTO_PER_PRICE);
    }
}
