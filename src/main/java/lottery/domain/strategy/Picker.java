package lottery.domain.strategy;

import lottery.domain.LotteryNumber;

import java.util.List;

@FunctionalInterface
public interface Picker {
    List<LotteryNumber> pick(int count);
}
