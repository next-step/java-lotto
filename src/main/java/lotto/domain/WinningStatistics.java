package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int MINIMUM_MATCH_COUNT = 3;
    private static final int MAXIMUM_MATCH_COUNT = 6;

    private List<Integer> lottoResultNumbers;
    private Map<Integer, Integer> resultGameStatistics;

    public WinningStatistics(List<Integer> lottoResultNumbers) {
        makeResultMap();

        this.lottoResultNumbers = lottoResultNumbers;
    }

    public Map<Integer, Integer> resultLottoGame(List<LottoGame> lottoGames) {

        for(LottoGame lottoGame : lottoGames) {
            addWinningStatistics(lottoGame.matchLottoNumberCount(this.lottoResultNumbers));
        }

        return this.resultGameStatistics;
    }

    private void addWinningStatistics(int matchCount) {
        if (matchCount >= MINIMUM_MATCH_COUNT) {
            this.resultGameStatistics.put(matchCount, this.resultGameStatistics.getOrDefault(matchCount, 0) + 1);
        }
    }

    private void makeResultMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = MINIMUM_MATCH_COUNT; i <= MAXIMUM_MATCH_COUNT; i++) {
            map.put(i, 0);
        }

        this.resultGameStatistics = map;
    }
}
