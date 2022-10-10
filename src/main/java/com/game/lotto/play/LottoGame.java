package com.game.lotto.play;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.MyTickets;
import com.game.lotto.ticket.TicketsByStrikes;

public class LottoGame {
    private final long inputPrice;
    private final long ticketCount;
    private final MyTickets myTickets;
    private TicketsByStrikes ticketsByStrikes;

    public LottoGame(long inputPrice, LottoNumberGenerator numberGenerator) {
        this.inputPrice = inputPrice;
        this.ticketCount = inputPrice / Ticket.PRICE_OF_TICKET_UNIT;
        this.myTickets = new MyTickets(ticketCount, numberGenerator);
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public double compareWithWinnerTicketAndGetEarningRates(Ticket winnerTicket) {
        ticketsByStrikes = new TicketsByStrikes(winnerTicket, myTickets.getTickets());
        return getEarningRates();
    }

    private double getEarningRates() {
        EarningRates earningRates = new EarningRates(inputPrice, ticketsByStrikes);
        return earningRates.calculateEarningRatesAndPrintResults();
    }
}
