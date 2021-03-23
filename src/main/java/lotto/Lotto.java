package lotto;

import java.util.ArrayList;
import java.util.List;

public final class Lotto {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final List<Integer> numbers;

  public Lotto() {
    numbers = new ArrayList<>();
    for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
      numbers.add(0);
    }
  }

  public List<Integer> numbers() {
    return numbers;
  }
}
