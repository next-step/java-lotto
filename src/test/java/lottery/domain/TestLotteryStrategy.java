package lottery.domain;

import java.util.Arrays;

public class TestLotteryStrategy implements LotteryStrategy {
    @Override
    public Lottery generate() {
        return Lottery.createLottery(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
