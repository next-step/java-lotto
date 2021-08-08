package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {

  private static final int START = 1;

  private static final int END = 46;

  private static final int FROM_INDEX = 0;

  private static final int TO_INDEX = 6;

  private static final List<Integer> numbers = new ArrayList<>();

  static {
    for(int number = START; number < END; number++){
      numbers.add(number);
    }
  }
  public GenerateLottoNumber() {
  }

  public static List<Integer> createNumberPull() {
    Collections.shuffle(numbers);
    return splitNumbers(numbers);
  }

  private static List<Integer> splitNumbers(final List<Integer> numberPull) {
    return numberPull.subList(FROM_INDEX, TO_INDEX);
  }

}
