package step2.generate;

import step2.lottery.LotteryNumber;

import java.util.Set;

public interface Generate {
    Set<LotteryNumber> makeNumbers(int size);
}
