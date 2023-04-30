package lottery.domain.numbergenerator;

import static lottery.domain.constant.LotteryNumberRule.MAX_LOTTERY_NUMBER;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();

    private static final int START_FROM_ONE = 1;

    @Override
    public int generatedNumber() {
        return RANDOM.nextInt(MAX_LOTTERY_NUMBER.getRuleNumber()) + START_FROM_ONE;
    }
}
