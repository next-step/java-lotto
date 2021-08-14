/*
 * Ticket.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticket;

import edu.nextstep.lottoauto.ticketManager.WinningNumbers;
import edu.nextstep.lottoauto.strategy.NumberMaker;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;
    private final Prize prize;


    public Ticket(List<Integer> numbersTmp) {
        this.numbers = numbersTmp;
        this.prize = null;
    }

    public static Ticket create(NumberMaker numberMaker) {
        return new Ticket(numberMaker.makeNumbers());
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
