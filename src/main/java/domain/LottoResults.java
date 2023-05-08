package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private final List<int[]> lottoResults;

    public LottoResults(List<int[]> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public LottoResults() {
        this.lottoResults = new ArrayList<>();
    }

    public void add(int[] generateNumbers) {
        lottoResults.add(generateNumbers);
    }

    public List<int[]> getLottoResults() {
        return lottoResults;
    }

    public void calculateWinningStatistics(WinningStatistics winningStatistics) {
        for (int[] lottoResult : lottoResults) {
            winningStatistics.matchCount(lottoResult);
        }
    }



}
