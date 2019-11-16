package lotto.domain;

import java.util.Map;

public class LottoStatistics {

    private Map<String, Integer> winCounts;
    private double winPercent;

    public LottoStatistics(Map<String, Integer> winCounts, Double winPercent) {

        this.winCounts = winCounts;
        this.winPercent = winPercent;
    }

    public Map<String, Integer> getWinCounts() {
        return winCounts;
    }

    public double getWinPercents() {
        return winPercent;
    }
}
