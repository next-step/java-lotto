package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES = generateNumbers();
  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  private RandomNumberGenerator() {}

  public static List<Integer> generate() {
    Collections.shuffle(POSSIBLE_LOTTO_NUMBER_CANDIDATES);
    return POSSIBLE_LOTTO_NUMBER_CANDIDATES.subList(0, 6);
  }

  private static List<Integer> generateNumbers() {
    List<Integer> candidates = new ArrayList<>();
    for (int lottoNumber = LOTTO_MIN_NUMBER; lottoNumber <= LOTTO_MAX_NUMBER; lottoNumber++) {
      candidates.add(lottoNumber);
    }
    return candidates;
  }
}
