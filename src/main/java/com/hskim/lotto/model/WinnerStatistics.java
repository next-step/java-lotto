package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class WinnerStatistics {
    private static final String STATISTIC_STRING_JOINING_DELIMITER = "\n";

    private final Map<LottoWinTable, Integer> winnerMap;

    public WinnerStatistics() {
        this.winnerMap = new LinkedHashMap<>();
        setDefaultData();
    }

    public WinnerStatistics(Map<LottoWinTable, Integer> winnerMap) {
        this.winnerMap = winnerMap;
        setDefaultData();
    }

    private void setDefaultData() {
        Arrays.stream(LottoWinTable.values())
                .forEach(this::putDefaultData);
    }

    private void putDefaultData(LottoWinTable winTable) {
        if (winnerMap.containsKey(winTable)) {
            return;
        }

        winnerMap.put(winTable, 0);
    }

    public void putData(LottoWinTable lottoWinTable) {
        winnerMap.put(lottoWinTable, winnerMap.getOrDefault(lottoWinTable, 0) + 1);
    }

    public String makeStatisticString() {
        return winnerMap.keySet()
                .stream()
                .map(this::makeDataString)
                .collect(Collectors.joining(STATISTIC_STRING_JOINING_DELIMITER));
    }

    private String makeDataString(LottoWinTable lottoWinTable) {
        return lottoWinTable.toString()
                + " - "
                + winnerMap.get(lottoWinTable)
                + "개";
    }

    public BigDecimal getTotalPrizeAmount() {
        return winnerMap.keySet()
                .stream()
                .map(this::getPrizeAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPrizeAmount(LottoWinTable winTable) {
        return BigDecimal.valueOf(
                winnerMap.get(winTable))
                .multiply(winTable.getPrizeAmount()
                );
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
