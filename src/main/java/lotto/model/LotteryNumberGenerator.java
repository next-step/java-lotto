package lotto.model;


import java.util.Set;

public interface LotteryNumberGenerator {
    Set<LotteryNumber> generate();
}
