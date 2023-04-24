package step2.vo;

import step2.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.LottoRank.MATCH_FIVE;
import static step2.LottoRank.MATCH_FOUR;
import static step2.LottoRank.MATCH_SIX;
import static step2.LottoRank.MATCH_THREE;

public class WinnerInfo {

    private static final int LOTTO_PER_PRICE = 1000;

    private static final int INIT_WINNER_COUNT = 0;

    private final Map<LottoRank, Integer> winnerResults;

    public WinnerInfo(List<Integer> matchingCounts) {
        winnerResults = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            winnerResults.put(lottoRank, INIT_WINNER_COUNT);
        }

        for (Integer matchingCount : matchingCounts) {
            countMatchedWinners(matchingCount);
        }
    }

    private void countMatchedWinners(Integer matchingCount) {
        if (LottoRank.isMatchingThree(matchingCount)) {
            winnerResults.compute(MATCH_THREE, (k, v) -> v + 1);
        }
        if (LottoRank.isMatchingFour(matchingCount)) {
            winnerResults.compute(MATCH_FOUR, (k, v) -> v + 1);
        }
        if (LottoRank.isMatchingFive(matchingCount)) {
            winnerResults.compute(MATCH_FIVE, (k, v) -> v + 1);
        }
        if (LottoRank.isMatchingSix(matchingCount)) {
            winnerResults.compute(MATCH_SIX, (k, v) -> v + 1);
        }
    }

    public double calculateRateOfReturn(int numOfLottoTicket) {
        return (LottoRank.getMatchThreePrizeAmount(winnerResults.get(MATCH_THREE))
                + LottoRank.getMatchFourPrizeAmount(winnerResults.get(MATCH_FOUR))
                + LottoRank.getMatchFivePrizeAmount(winnerResults.get(MATCH_FIVE))
                + LottoRank.getMatchSixPrizeAmount(winnerResults.get(MATCH_SIX)))
                / (numOfLottoTicket * LOTTO_PER_PRICE);
    }

    public Map<LottoRank, Integer> getWinnerResults() {
        return winnerResults;
    }
}
