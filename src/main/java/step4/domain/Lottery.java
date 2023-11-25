package step4.domain;

import java.util.List;

import step4.constant.LotteryNumber;
import step4.util.LotteryUtil;

public class Lottery {

    private final List<LotteryNumber> lotteryNumbers;

    public Lottery(List<LotteryNumber> numbers) {
        this.lotteryNumbers = numbers;
    }

    public static Lottery of(List<Integer> numbers) {
        return new Lottery(LotteryNumber.of(numbers));
    }

    public List<Integer> getLotteryNumbers() {
        List<Integer> numbers = LotteryNumber.getNumbers(lotteryNumbers);
        LotteryUtil.validateNumbers(numbers);

        return numbers;
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
}
