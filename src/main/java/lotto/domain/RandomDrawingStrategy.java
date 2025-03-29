package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomDrawingStrategy implements DrawingStrategy{

  private static final int MAX_NUMBER = 45;
  private static final List<Integer> POOL = new ArrayList<>();

  static {
    for (int i = 1; i <= MAX_NUMBER; i++) {
      POOL.add(i);
    }
  }

  public RandomDrawingStrategy() {
  }

  @Override
  public List<Integer> draw() {
    List<Integer> shuffledList = new ArrayList<>(POOL);
    Collections.shuffle(shuffledList);
    return shuffledList.subList(0, 6);
  }
}
