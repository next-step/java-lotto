package lottery.domain;

import java.util.Collections;
import java.util.List;

public class AutoBuyBehavior implements BuyBehavior {
    public static final int FROM_INDEX = 0;
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;

    @Override
    public List<LotteryNumber> getLotteryNumbers() {
        Collections.shuffle(lotteryAllNumbers);
        return lotteryAllNumbers.subList(FROM_INDEX, NUMBER_OF_LOTTERY_NUMBERS);
    }

    @Override
    public List<LotteryNumber> getLotteryNumbersBy(String numbers) {
        return null;
    }
}
