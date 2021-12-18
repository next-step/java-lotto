package step2.strategy;

import step2.domain.util.LotteryGenerator;

import java.util.List;

public class AutoLotteryStrategy implements LotteryStrategy {

    @Override
    public List<Integer> getLotteryNumbers() {
        return LotteryGenerator.pickNumbers();
    }
}
