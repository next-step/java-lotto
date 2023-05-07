package lottery.domain;

import static lottery.domain.Lottery.lotteryFactory;

import java.util.Arrays;

public class LotteryDummyData {

    private final WeeklyWinningNumbers weeklyWinningNumbers;

    private final Lotteries lotteries;

    protected LotteryDummyData() {
        this.weeklyWinningNumbers = new WeeklyWinningNumbers("1,2,3,41,42,43", 7);
        Lottery firstPlace = lotteryFactory("1, 2, 3, 41, 42, 43");
        Lottery secondPlace = lotteryFactory("1, 2, 3, 41, 42, 7");
        Lottery thirdPlace = lotteryFactory("1, 2, 3, 41, 42, 45");
        Lottery fourthPlace = lotteryFactory("1, 2, 3, 41, 9, 11");
        Lottery fifthPlace = lotteryFactory("1, 2, 3, 7, 8, 9");
        this.lotteries = new Lotteries(
                Arrays.asList(firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace));
    }

    public WeeklyWinningNumbers winningNumbersDummyObj() {
        return this.weeklyWinningNumbers;
    }

    public Lotteries lotteriesDummyObj() {
        return this.lotteries;
    }
}
