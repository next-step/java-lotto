package lotto;

import java.util.Map;

public class StatisticsReport {

    private final Map<Prize, Integer> matchCountByPrize;
    public StatisticsReport(Map<Prize, Integer> matchCountByPrize1) {
        this.matchCountByPrize = matchCountByPrize1;
    }

    public int countByPrize(Prize prize) {
        return matchCountByPrize.get(prize);
    }
}
