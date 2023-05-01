package lottery.domain;

import java.util.Set;

public class WinningNumbers {

    private final SixLotteryNumbers winningNumbers;

    public WinningNumbers(String numberChunk) {
        this(new SixLotteryNumbers(numberChunk));
    }

    public WinningNumbers(SixLotteryNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int size() {
        return winningNumbers.size();
    }

    public Set<LotteryNumber> getNumbers() {
        return winningNumbers.getNumbers();
    }

}
