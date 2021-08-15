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

    public static Ticket create(NumberMaker numberMaker) {
        return new Ticket(numberMaker.makeNumbers());
    }

    public void checkAndUpdateWinningPrize(WinningNumbers winningNumbers) {
        int count = countSameNumbers(winningNumbers);
        if (count >= 3) {
            setPrize(count);
        }
    }

    private int countSameNumbers(WinningNumbers winningNumbers) {
        return (int) winningNumbers.getWinningNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    private void setPrize(int count) {
        this.prize = Prize.from(count);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getPrize() {
        return prize;
    }
}
