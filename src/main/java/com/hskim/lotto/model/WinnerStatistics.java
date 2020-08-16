package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.util.*;

public class WinnerStatistics {

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

    public Map<LottoWinTable, Integer> getWinnerMap() {
        return winnerMap;
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
