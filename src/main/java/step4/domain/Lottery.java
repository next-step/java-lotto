package step4.domain;

import java.util.List;

import step4.constant.LotteryNumber;

public class Lottery {

    public static final int WINNING_STREAK = 6;

    private final List<LotteryNumber> lotteryNumbers;

    public Lottery(List<LotteryNumber> numbers) {
        validateNumbers(numbers);
        this.lotteryNumbers = numbers;
    }

    public static Lottery of(List<Integer> numbers) {
        return new Lottery(LotteryNumber.of(numbers));
    }

    public List<Integer> getLotteryNumbers() {
        return LotteryNumber.getNumbers(lotteryNumbers);
    }

    public int getMatchCount(Lottery win) {
        int winCount = 0;
        for (int number : getLotteryNumbers()) {
            if (win.getLotteryNumbers().contains(number)) {
                winCount++;
            }
        }

        return winCount;
    }

    private static void validateNumbers(List<LotteryNumber> numbers) {
        if (WINNING_STREAK != numbers.size()) {
            throw new IllegalArgumentException("잘 못 생성된 로또 - " + numbers.size());
        }
    }
}
