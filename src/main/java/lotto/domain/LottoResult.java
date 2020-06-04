package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<WinningSheet, Integer> winningStatistics;

    public LottoResult(List<WinningSheet> winningSheets) {
        this.winningStatistics = makeStatistics(winningSheets);
    }

    private Map<WinningSheet, Integer> makeStatistics(List<WinningSheet> winningSheets) {
        Map<WinningSheet, Integer> statistics = new EnumMap<>(WinningSheet.class);

        for (WinningSheet winningSheet : WinningSheet.values()) {
            statistics.put(winningSheet, winningSheet.countInList(winningSheets));
        }

        statistics.remove(WinningSheet.FAIL);

        return Collections.unmodifiableMap(statistics);
    }

    public Map<WinningSheet, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public int sumAllPrize() {
        return winningStatistics.entrySet().stream()
                .mapToInt(statistic -> statistic.getKey().getPrize() * statistic.getValue())
                .sum();
    }
}
