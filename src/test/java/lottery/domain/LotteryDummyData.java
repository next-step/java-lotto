package lottery.domain;

import java.util.Arrays;

public class LotteryDummyData {

    private final WinningNumbers winningNumbers;

    private final Lotteries lotteries;

    protected LotteryDummyData() {
        this.winningNumbers = new WinningNumbers("1,2,3,41,42,43");
        Lottery firstPlace = new Lottery(new int[]{1, 2, 3, 41, 42, 43});
        Lottery secondPlace = new Lottery(new int[]{1, 2, 3, 41, 42, 45});
        Lottery thirdPlace = new Lottery(new int[]{1, 2, 3, 7, 42, 45});
        Lottery fourthPlace = new Lottery(new int[]{1, 2, 8, 7, 42, 45});
        this.lotteries = new Lotteries(
                Arrays.asList(firstPlace, secondPlace, thirdPlace, fourthPlace));
    }

    public WinningNumbers winningNumbersDummyObj() {
        return this.winningNumbers;
    }

    public Lotteries lotteriesDummyObj() {
        return this.lotteries;
    }
}
