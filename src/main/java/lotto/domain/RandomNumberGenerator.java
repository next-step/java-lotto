package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomNumberGenerator implements NumberGenerator {

  private final Random random;

  public RandomNumberGenerator(Random random) {
    this.random = random;
  }

  @Override
  public List<Integer> generateNumbers() {
    return IntStream
        .range(0, 6)
        .mapToObj(count -> random.nextInt(45) + 1)
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
