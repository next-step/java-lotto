package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES = new ArrayList<>();

  private RandomNumberGenerator() {
    for (int i = 1; i <=45; i++) {
      POSSIBLE_LOTTO_NUMBER_CANDIDATES.add(i);
    }
  }

  public static List<Integer> generate() {
    RandomNumberGenerator generator = new RandomNumberGenerator();
    Collections.shuffle(POSSIBLE_LOTTO_NUMBER_CANDIDATES);
    return POSSIBLE_LOTTO_NUMBER_CANDIDATES.subList(0, 6);
  }
}
