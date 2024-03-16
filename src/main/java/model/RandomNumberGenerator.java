package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES = generateNumbers();

  private RandomNumberGenerator() {}

  public static List<Integer> generate() {
    Collections.shuffle(POSSIBLE_LOTTO_NUMBER_CANDIDATES);
    return POSSIBLE_LOTTO_NUMBER_CANDIDATES.subList(0, 6);
  }

  private static List<Integer> generateNumbers() {
    List<Integer> candidates = new ArrayList<>();
    for (int i = 1; i <= 45; i++) {
      candidates.add(i);
    }
    return candidates;
  }
}
