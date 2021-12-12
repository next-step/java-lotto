package step2.strategy;

import step2.domain.util.RandomUtil;

import java.util.List;

public class ManualLotteryStrategy implements LotteryStrategy {

    @Override
    public List<Integer> getLotteryNumbers() {
        return RandomUtil.getRandomNumbers();
    }
}
