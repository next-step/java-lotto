package com.game.lotto.play;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.*;

public class LottoGame {
    private final long inputPrice;
    private final MyTickets myTickets;

    public LottoGame(int inputPrice, LottoNumberGenerator numberGenerator) {
        this.inputPrice = inputPrice;
        this.myTickets = new MyTickets(new TicketCount(inputPrice), numberGenerator);
    }

    public double compareWithWinnerTicketAndGetEarningRates(WinnerTicket winnerTicket) {
        TicketsByRanks ticketsByRanks = new TicketsByRanks(winnerTicket, myTickets.getTickets());
        return getEarningRates(ticketsByRanks);
    }

    private double getEarningRates(TicketsByRanks ticketsByRanks) {
        EarningRates earningRates = new EarningRates(inputPrice, ticketsByRanks);
        return earningRates.calculateEarningRatesAndPrintResults();
    }
}
