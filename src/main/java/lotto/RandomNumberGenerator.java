package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {

  private final Random random;

  public RandomNumberGenerator() {
    this.random = new Random();
  }

  @Override
  public List<Integer> generate(int limit) {
    return random.ints(1, 46)
            .distinct()
            .limit(6)
            .boxed()
            .collect(Collectors.toList());
  }
}
