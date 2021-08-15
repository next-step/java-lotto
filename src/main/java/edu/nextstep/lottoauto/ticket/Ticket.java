/*
 * Ticket.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticket;

import edu.nextstep.lottoauto.ticketManager.WinningNumbers;
import edu.nextstep.lottoauto.strategy.NumberMaker;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ticket {
    private final List<Integer> numbers;
    private Prize prize;

    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
        this.prize = null;
    }

    public static Ticket create(NumberMaker numberMaker) {
        List<Integer> numbers = numberMaker.makeNumbers();

        validateNumberOfNumbers(numbers);
        validateOutOfRange(numbers);
        validateSameNumber(numbers);

        return new Ticket(numbers);
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

    private static void validateNumberOfNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("복권 번호는 6개가 필요 합니다.");
        }
    }

    private static void validateOutOfRange(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
        if (winningNumbers.get(0) < 1 || winningNumbers.get(5) > 45) {
            throw new IllegalArgumentException("복권 번호는 1~45 의 범위 안에 있어야 합니다.");
        }
    }

    private static void validateSameNumber(List<Integer> winningNumbers) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        if (winningNumbersSet.size() < 6) {
            throw new IllegalArgumentException("복권 번호는 중복되지 않아야 합니다.");
        }
    }
}
