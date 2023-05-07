package lotto.util;

import lotto.model.LotteryNumber;

import java.util.Set;

public interface LotteryNumberGenerator {
    Set<LotteryNumber> generate();
}
