/*
 * TicketManager.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.strategy.NumberMaker;
import edu.nextstep.lottoauto.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private static final int PRICE_PER_ONE_TICKET = 1_000;

    private final List<Ticket> tickets = new ArrayList<>();

    private WinningNumbers winningNumbers;
    private WinningPrizeResult winningPrizeResult;

    public void createTickets(int payment, NumberMaker numberMaker) {
        int numberOfTickets = payment / PRICE_PER_ONE_TICKET;
        while (numberOfTickets > 0) {
            tickets.add(Ticket.create(numberMaker));
            numberOfTickets--;
        }
    }

    public void setWinningNumbersFrom(String winningNumbersString) {
        this.winningNumbers = WinningNumbers.from(winningNumbersString);
    }

    public WinningPrizeResult makeWinningPrizeResult() {
        this.winningPrizeResult = new WinningPrizeResult();
        for (Ticket ticket : tickets) {
            ticket.checkAndUpdateWinningPrize(winningNumbers);
            if (ticket.getPrize() != null) {
                winningPrizeResult.add(ticket);
            }
        }
        return winningPrizeResult;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }


}
