package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomIntegerListGenerator {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private static final int START_INDEX = 0;
  private static final int LAST_INDEX = 6;
  private static final List<Integer> BASE_NUMBERS = new ArrayList<>();

  static {
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      BASE_NUMBERS.add(i);
    }
  }

  private RandomIntegerListGenerator() {
  }

  public static List<Integer> getRandomIntegers() {
    Collections.shuffle(BASE_NUMBERS);
    List<Integer> picked = BASE_NUMBERS.subList(START_INDEX, LAST_INDEX);
    Collections.sort(picked);
    return picked;
  }
}
