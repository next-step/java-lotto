package lotto.domain;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int SIZE_LOTTO_NUMBER = 6;
    public static final int LOTTO_PRICE = 1000;

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

    public int countMatchingNumber(WinningNumber winningNumber) {
        return winningNumber.countMatchingNumber(numbers);
    }

    public boolean isBonusBallMatched(WinningNumber winningNumber) {
        return winningNumber.isBonusBallMatched(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
