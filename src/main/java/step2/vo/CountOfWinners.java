package step2.vo;

import step2.service.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfWinners {

    private static final int INIT_WINNER_COUNT = 0;

    private final Map<LottoRank, Integer> winnerResults;

    public CountOfWinners(List<LottoRank> matchingLottoRank) {
        winnerResults = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            winnerResults.put(lottoRank, INIT_WINNER_COUNT);
        }

        for (LottoRank lottoRank : matchingLottoRank) {
            Integer prevValue = winnerResults.get(lottoRank);
            winnerResults.put(lottoRank, ++prevValue);
        }
    }

    public double calculateRateOfReturn(int numOfLottoTicket) {
        return LottoRank.calculateRateOfReturn(numOfLottoTicket, winnerResults);
    }

    public Map<LottoRank, Integer> getWinnerResults() {
        return winnerResults;
    }
}
