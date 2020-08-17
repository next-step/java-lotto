package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoGameResult {

    private WinnerStatistics winnerStatistics = new WinnerStatistics();
    private EarningRate earningRate;

    public LottoGameResult() {

    }

    public LottoGameResult(WinnerStatistics winnerStatistics, EarningRate earningRate) {
        this.winnerStatistics = winnerStatistics;
        this.earningRate = earningRate;
    }

    public void putWinnerStatisticsData(List<LottoWinTable> lottoWinTables) {
        winnerStatistics.putData(lottoWinTables);
    }

    public void calculateEarningRate(int totalTicketsPrice) {
        earningRate = new EarningRate(winnerStatistics.getTotalPrizeAmount()
                , BigDecimal.valueOf(totalTicketsPrice));
    }

    public Map<LottoWinTable, Integer> getStatisticMap() {
        return winnerStatistics.getWinnerMap();
    }

    public String getEarningRate() {
        return earningRate.getEarningRate();
    }

    public boolean isProfit() {
        return earningRate.isProfit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoGameResult)) return false;
        LottoGameResult that = (LottoGameResult) o;
        return Objects.equals(winnerStatistics, that.winnerStatistics) &&
                Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerStatistics, earningRate);
    }
}
