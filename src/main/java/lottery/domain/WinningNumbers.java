package lottery.domain;

import java.util.Set;

public class WinningNumbers {

    private final Lottery winningNumbers;

    public WinningNumbers(String numberChunk) {
        this(new Lottery(numberChunk));
    }

    public WinningNumbers(Lottery winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int size() {
        return winningNumbers.size();
    }

    public Set<LotteryNumber> getNumbers() {
        return winningNumbers.getNumbers();
    }

}
