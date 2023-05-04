package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLotteryStrategy implements LotteryStrategy {
    Random random;
    public RandomLotteryStrategy() {
        random = new Random();
    }

    @Override
    public Lottery generate() {
        List<Integer> lotteryNumbers = new ArrayList<>();
        for(int i = 0; i < Lotteries.LOTTERY_LENGTH; i++) {
            lotteryNumbers.add(Lotteries.MIN_LOTTERY_NUMBER + random.nextInt(Lotteries.MAX_LOTTERY_NUMBER - Lotteries.MIN_LOTTERY_NUMBER));
        }
        Collections.sort(lotteryNumbers);
        return Lottery.createLottery(lotteryNumbers);
    }
}
