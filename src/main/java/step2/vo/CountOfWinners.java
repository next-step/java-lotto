package step2.vo;

import step2.service.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfWinners {

    private static final int INIT_WINNER_COUNT = 0;

    private final Map<LottoRank, Integer> winnerResults;

    public CountOfWinners(List<Integer> matchingCounts) {
        winnerResults = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            winnerResults.put(lottoRank, INIT_WINNER_COUNT);
        }

        for (Integer matchingCount : matchingCounts) {
            countMatchedWinners(matchingCount);
        }
    }

    private void countMatchedWinners(Integer matchingCount) {
        LottoRank lottoNumber = LottoRank.getLottoNumber(matchingCount);
        if (LottoRank.isRemain(lottoNumber)) {
            return;
        }
        winnerResults.compute(lottoNumber, (k,v) -> v + 1);
    }

    public double calculateRateOfReturn(int numOfLottoTicket) {
        return LottoRank.calculateRateOfReturn(numOfLottoTicket, winnerResults);
    }

    public Map<LottoRank, Integer> getWinnerResults() {
        return winnerResults;
    }
}
