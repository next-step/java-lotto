package lotto.domain;

import java.util.Map;

public class LottoStatistics {

    private Map<Rank, Integer> winCounts;
    private double winPercent;

    public LottoStatistics(Map<Rank, Integer> winCounts, Double winPercent) {

        this.winCounts = winCounts;
        this.winPercent = winPercent;
    }

    public Map<Rank, Integer> getWinCounts() {
        return winCounts;
    }

    public double getWinPercents() {
        return winPercent;
    }
}
