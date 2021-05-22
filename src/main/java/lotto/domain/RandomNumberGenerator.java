package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RandomNumberGenerator implements NumberGenerator {

  private final Random random;

  public RandomNumberGenerator(Random random) {
    this.random = random;
  }

  @Override
  public List<Integer> generateNumbersOf(Integer numberCount) {
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int count = 0; count < numberCount; count++) {
      numbers.add(random.nextInt(45) + 1);
    }

    return numbers;
  }
}
