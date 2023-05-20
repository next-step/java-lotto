package lotto.domain;

import java.util.List;

import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

public class Ticket {
    private final List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public boolean checkValidTickets() {
        return numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER);
    }

    public PrizeType checkLotteryWinningStatus(WinningNumber winningNumber) {
        return PrizeType.create(countMatchingNumber(winningNumber), isBonusBallMatched(winningNumber));
    }

    private int countMatchingNumber(WinningNumber winningNumber) {
        return (int) winningNumber.getWinningNumber().stream()
                .filter(w -> numbers.contains(w))
                .count();
    }

    private boolean isBonusBallMatched(WinningNumber winningNumber) {
        BonusBall bonusBall = winningNumber.getBonusBall();
        return numbers.contains(bonusBall.getBonusBallNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
