package com.game.lotto.play;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.*;

public class LottoGame {
    private final long inputPrice;
    private final TicketCount ticketCount;
    private final MyTickets myTickets;
    private TicketsByRanks ticketsByRanks;

    public LottoGame(int inputPrice, LottoNumberGenerator numberGenerator) {
        this.inputPrice = inputPrice;
        this.ticketCount = new TicketCount(inputPrice);
        this.myTickets = new MyTickets(ticketCount, numberGenerator);
    }

    public int getTicketCount() {
        return ticketCount.getCount();
    }

    public double compareWithWinnerTicketAndGetEarningRates(WinnerTicket winnerTicket) {
        ticketsByRanks = new TicketsByRanks(winnerTicket, myTickets.getTickets());
        return getEarningRates();
    }

    private double getEarningRates() {
        EarningRates earningRates = new EarningRates(inputPrice, ticketsByRanks);
        return earningRates.calculateEarningRatesAndPrintResults();
    }
}
