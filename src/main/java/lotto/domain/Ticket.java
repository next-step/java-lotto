package lotto.domain;

import lombok.Getter;

import java.util.List;

import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.PrizeType.*;

public class Ticket {
    @Getter
    private List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public boolean checkValidTickets() {
        return numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER);
    }

    public int numberOfMatching(WinningNumber winningNumber) {
        return (int) winningNumber.getWinningNumber().stream()
                .filter(w -> numbers.contains(w))
                .count();
    }

    public PrizeType typeOfMatching(WinningNumber winningNumber) {
        int matchingCount = numberOfMatching(winningNumber);

        if (matchingCount == FIRST_PRIZE.numberOfMatching()) {
            return FIRST_PRIZE;
        }
        if (matchingCount == SECOND_PRIZE.numberOfMatching()) {
            return SECOND_PRIZE;
        }
        if (matchingCount == THIRD_PRIZE.numberOfMatching()) {
            return THIRD_PRIZE;
        }
        if (matchingCount == FOURTH_PRIZE.numberOfMatching()) {
            return FOURTH_PRIZE;
        }
        return NOT_MATCHING;
    }
}
