package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class GenerateStrategyRandom implements GenerateStrategy {
  private final Random random = new Random();

  @Override
  public Lotto generate() {
    return Lotto.of(this.nonDuplicatedRandomNumbers(Lotto.LOTTO_BALLS_COUNT));
  }

  protected List<LottoBall> nonDuplicatedRandomNumbers(final int size) {
    Set<Integer> integerSet = new HashSet<>();
    while (integerSet.size() != size) {
      integerSet.add(this.random.nextInt(LottoBall.UPPER_BOUND.value()) + 1);
    }
    return integerSet.stream()
            .map(LottoBall::of)
            .collect(toList());
  }
}
