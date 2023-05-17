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
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for(int i = 0; i < Lottery.LENGTH; i++) {
            lotteryNumbers.add(new LotteryNumber(LotteryNumber.MIN + random.nextInt(LotteryNumber.MAX - LotteryNumber.MIN)));
        }
        Collections.sort(lotteryNumbers);
        return Lottery.createLottery(lotteryNumbers);
    }
}
