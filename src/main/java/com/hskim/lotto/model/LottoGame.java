package com.hskim.lotto.model;

import java.util.*;

public class LottoGame {

    private LottoTickets lottoTickets;
    private LottoWinningTicket winningTicket;
    private WinnerStatistics winnerStatistics = new WinnerStatistics();

    public LottoGame(LottoTickets lottoTickets, LottoWinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public void drawLots() {
        lottoTickets.getLottoTicketStream()
                .map(this::mapToWinnerTable)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(winnerStatistics::putData);
    }

    private Optional<LottoWinTable> mapToWinnerTable(LottoTicket lottoTicket) {
        return winningTicket.findWinnerTable(lottoTicket);
    }

    public String getWinnerStatisticString() {
        return winnerStatistics.makeStatisticString();
    }

    public String getEarningRateString() {
        return new EarningRate(winnerStatistics.getTotalPrizeAmount(),
                lottoTickets.getTotalTicketPrice())
                .makeEarningRateString();
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
