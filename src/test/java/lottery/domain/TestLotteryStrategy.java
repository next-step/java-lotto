package lottery.domain;

import java.util.Arrays;

public class TestLotteryStrategy implements LotteryStrategy {
    @Override
    public Lottery generate() {
        return Lottery.createLottery(Arrays.asList(new LotteryNumber(1), new LotteryNumber(2), new LotteryNumber(3), new LotteryNumber(4), new LotteryNumber(5), new LotteryNumber(6)));
    }
}
