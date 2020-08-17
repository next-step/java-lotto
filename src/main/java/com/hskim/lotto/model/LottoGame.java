package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.util.*;

public class LottoGame {

    private LottoTickets lottoTickets;
    private LottoWinningTicket winningTicket;
    private WinnerStatistics winnerStatistics = new WinnerStatistics();
    private EarningRate earningRate;

    public LottoGame(LottoTickets lottoTickets, LottoWinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public void drawLots() {
        lottoTickets.getWinTableList(winningTicket)
                .forEach(winnerStatistics::putData);

        earningRate = new EarningRate(winnerStatistics.getTotalPrizeAmount()
                , BigDecimal.valueOf(lottoTickets.getTotalTicketPrice()));
    }

    public Map<LottoWinTable, Integer> getWinnerMap() {
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
        if (!(o instanceof LottoGame)) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lottoTickets, lottoGame.lottoTickets) &&
                Objects.equals(winningTicket, lottoGame.winningTicket) &&
                Objects.equals(winnerStatistics, lottoGame.winnerStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets, winningTicket, winnerStatistics);
    }
}
