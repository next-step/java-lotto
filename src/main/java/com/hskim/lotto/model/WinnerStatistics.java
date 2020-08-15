package com.hskim.lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerStatistics {
    private static final String STATISTIC_STRING_JOINING_DELIMITER = "\n";

    private final Map<LottoWinTable, Integer> winnerMap;

    public WinnerStatistics() {
        this.winnerMap = new HashMap<>();
    }

    public WinnerStatistics(Map<LottoWinTable, Integer> winnerMap) {
        this.winnerMap = winnerMap;
    }

    public void putData(LottoWinTable lottoWinTable) {
        winnerMap.put(lottoWinTable, winnerMap.getOrDefault(lottoWinTable, 0) + 1);
    }

    public String makeStatisticString() {
        return winnerMap.keySet()
                .stream()
                .map(this::getDataString)
                .collect(Collectors.joining(STATISTIC_STRING_JOINING_DELIMITER));
    }

    private String getDataString(LottoWinTable lottoWinTable) {
        return lottoWinTable.toString()
                + " - "
                + winnerMap.get(lottoWinTable)
                + "개";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinnerStatistics)) return false;
        WinnerStatistics that = (WinnerStatistics) o;
        return Objects.equals(winnerMap, that.winnerMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerMap);
    }
}
