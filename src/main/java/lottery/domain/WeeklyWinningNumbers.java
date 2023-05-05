package lottery.domain;

import static lottery.domain.Lottery.lotteryFactory;

import java.util.Set;

public class WeeklyWinningNumbers {

    private final Lottery weeklyWinningNumbers;

    public WeeklyWinningNumbers(String numberChunk) {
        this(lotteryFactory(numberChunk));
    }

    public WeeklyWinningNumbers(Lottery weeklyWinningNumbers) {
        this.weeklyWinningNumbers = weeklyWinningNumbers;
    }

    public int size() {
        return weeklyWinningNumbers.size();
    }

    public Set<LotteryNumber> getNumbers() {
        return weeklyWinningNumbers.getNumbers();
    }

}
