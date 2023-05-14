package lotto.model;


import java.util.Set;

@FunctionalInterface
public interface LotteryNumberGenerator {
    Set<LotteryNumber> generate();
}
