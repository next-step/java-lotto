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
    private Prize prize;


    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
        this.prize = null;
    }

    private Ticket(List<Integer> numbers, Prize prize) {
        this.numbers = numbers;
        this.prize = prize;
    }

    public static Ticket create(NumberMaker numberMaker) {
        return new Ticket(numberMaker.makeNumbers());
    }

    public void checkAndUpdateWinningPrize(WinningNumbers winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers.getWinningNumbers()) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        if (count >= 3) {
            for (Prize p : Prize.values()) {
                if (p.getValue() == count) {
                    this.prize = p;
                }
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getPrize() {
        return prize;
    }


}
