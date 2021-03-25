package lotto.util;

import java.util.Random;

public class RandomNumberGenerator extends Random {

  private static final int RANDOM_NUMBER_BOUND = 45;
  private final Random seed;

  public RandomNumberGenerator() {
    this.seed = new Random(System.currentTimeMillis());
  }

  public int generatedRandomNumber() {
    return seed.nextInt(RANDOM_NUMBER_BOUND) + 1;
  }
}
