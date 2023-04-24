package step2.vo;

import step2.service.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerInfo {


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
        LottoRank lottoRank = LottoRank.getLottoNumber(matchingCount);
        winnerResults.compute(lottoRank, (k, v) -> v + 1);
    }

    public double calculateRateOfReturn(int numOfLottoTicket) {
        return LottoRank.calculateRateOfReturn(numOfLottoTicket, winnerResults);
    }

    public Map<LottoRank, Integer> getWinnerResults() {
        return winnerResults;
    }
}
