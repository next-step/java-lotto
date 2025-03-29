package lotto.strategy.pick;

import java.util.Random;

public class RandomNumberPickStrategy implements NumberPickStrategy {

  private final Random random;

  public RandomNumberPickStrategy() {
    this.random = new Random();
  }

  @Override
  public int pick(int min, int max) {
    return random.nextInt(max) + 1;
  }
}
