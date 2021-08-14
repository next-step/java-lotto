/*
 * TicketManager.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.strategy.TicketMaker;
import edu.nextstep.lottoauto.ticket.Ticket;

import java.util.List;

public class TicketManager {
    private List<Ticket> tickets;
    private WinningNumbers winningNumbers;
    private WinningPrizeResult winningPrizeResult;

    public void createTickets(int payment, TicketMaker ticketMaker) {
    }


    public List<Ticket> getTickets() {
        return tickets;
    }

    public WinningPrizeResult makeWinningPrizeResult() {
        return null;
    }

    public void setWinningNumbersFrom(String winningNumbersString) {
        this.winningNumbers = WinningNumbers.from(winningNumbersString);
    }
}
