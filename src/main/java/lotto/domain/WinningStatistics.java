package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int MINIMUM_MATCH_COUNT = 3;

    private List<Integer> lottoResultNumbers;
    private Map<Integer, Integer> resultGameStatistics;

    public WinningStatistics(List<Integer> lottoResultNumbers) {
        makeResultMap();

        this.lottoResultNumbers = lottoResultNumbers;
    }

    public Map<Integer, Integer> resultLottoGame(List<LottoGame> lottoGames) {

        for(LottoGame lottoGame : lottoGames) {
            this.resultGameStatistics.put(lottoGame.matchLottoNumberCount(this.lottoResultNumbers)
                    , this.resultGameStatistics.getOrDefault(lottoGame.matchLottoNumberCount(this.lottoResultNumbers), 0) + 1);
        }

        removeMinMatchCount();

        return this.resultGameStatistics;
    }

    private void makeResultMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= 6; i++) {
            map.put(i, 0);
        }

        this.resultGameStatistics = map;
    }

    private void removeMinMatchCount() {

        for(int key = 0 ; key < MINIMUM_MATCH_COUNT; key++) {
            this.resultGameStatistics.remove(key);
        }
    }
}
