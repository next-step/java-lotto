package lotto.model;

import lotto.model.LotteryNumber;

import java.util.Set;

public interface LotteryNumberGenerator {
    Set<LotteryNumber> generate();
}
