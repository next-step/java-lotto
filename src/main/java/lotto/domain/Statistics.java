package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {

    private static final int CRITERIA_OF_WINNING = 3;
    private static final int UNIT = 1;
    private Map<WinnigType, Integer> statistics;

    public Statistics() {
        statistics = new LinkedHashMap<>();
        for (WinnigType winnigType : WinnigType.values()) {
            statistics.put(winnigType, 0);
        }
    }

    public Map<WinnigType, Integer> getStatistics(List<Long> matchCntList) {
        statistics.putAll(statisticsOfLotto(matchCntList));
        return statistics;
    }

    private Map<WinnigType, Integer> statisticsOfLotto(List<Long> matchCntList) {
        return matchCntList.stream()
                .filter(value -> value >= CRITERIA_OF_WINNING)
                .collect(Collectors.toMap(matchCnt -> WinnigType.of(matchCnt), value -> UNIT, Integer::sum));
    }

    public double getRateOfReturn(int money) {
        int earning = getEarning();
        return Math.floor(earning / (double)money * 100) / 100;
    }

    private int getEarning() {
        int sum = 0;
        for (Map.Entry<WinnigType, Integer> entry : statistics.entrySet()) {
            sum += entry.getKey().getWinningAmount() * entry.getValue();
        }
        return sum;
    }
}
