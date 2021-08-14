/*
 * Ticket.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticket;

import edu.nextstep.lottoauto.ticketManager.WinningNumbers;
import edu.nextstep.lottoauto.strategy.TicketMaker;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;
    private final Prize prize;


    public Ticket(List<Integer> numbersTmp) {
        this.numbers = numbersTmp;
        this.prize = null;
    }

    public static Ticket create(TicketMaker ticketMaker) {
        return ticketMaker.makeTicket();
    }

    public void checkAndUpdateWinningPrize(WinningNumbers winningNumbers) {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getPrize() {
        return prize;
    }


}
