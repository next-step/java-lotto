package lotto.domain.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {

  private static final int MIN = 1, MAX = 45;

  public static List<Integer> generate() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = MIN; i <= MAX; i++) {
      numbers.add(i);
    }
    Collections.shuffle(numbers);
    List<Integer> selected = numbers.subList(0, 6);
    Collections.sort(selected);
    return selected;
  }
}