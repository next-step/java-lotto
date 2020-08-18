package com.hskim.lotto.model;

import java.util.*;

public class LottoGame {

    private LottoTickets lottoTickets;
    private LottoWinningTicket winningTicket;
    private LottoGameResult lottoGameResult = new LottoGameResult();

    public LottoGame(LottoTickets lottoTickets, LottoWinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public LottoGameResult drawLotteryTicket() {
        makeStatistic();
        calculateEarningRate();
        return lottoGameResult;
    }

    private void makeStatistic() {
        lottoGameResult.putWinnerStatisticsData(lottoTickets.getWinTableList(winningTicket));
    }

    private void calculateEarningRate() {
        lottoGameResult.calculateEarningRate(lottoTickets.getTotalTicketPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoGame)) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lottoTickets, lottoGame.lottoTickets) &&
                Objects.equals(winningTicket, lottoGame.winningTicket) &&
                Objects.equals(lottoGameResult, lottoGame.lottoGameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets, winningTicket, lottoGameResult);
    }
}
