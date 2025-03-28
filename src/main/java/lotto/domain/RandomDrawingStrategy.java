package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomDrawingStrategy implements DrawingStrategy{

  private static final int MAX_NUMBER = 45;
  private static final List<Integer> POOL = new ArrayList<>();
  private static final RandomDrawingStrategy LOTTO_NUMBER_GENERATOR = new RandomDrawingStrategy();

  static {
    for (int i = 1; i <= MAX_NUMBER; i++) {
      POOL.add(i);
    }
  }

  public RandomDrawingStrategy() {
  }

  public static RandomDrawingStrategy getInstance() {
    return LOTTO_NUMBER_GENERATOR;
  }

  @Override
  public List<Integer> draw() {
    List<Integer> shuffledList = new ArrayList<>(POOL);
    Collections.shuffle(shuffledList);
    return shuffledList.subList(0, 6);
  }
}
