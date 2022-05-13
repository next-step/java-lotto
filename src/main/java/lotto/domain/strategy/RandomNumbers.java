package lotto.domain.strategy;

import static java.util.stream.IntStream.rangeClosed;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers implements GenerateNumbersStrategy {

  private static final int FROM_INDEX = 0;
  private static final int TO_INDEX = 6;
  private static final int LOTTO_START_NUMBER = 1;
  private static final int LOTTO_END_NUMBER = 45;

  public List<Integer> generate() {
    List<Integer> numbers = rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER).boxed()
        .collect(Collectors.toList());
    Collections.shuffle(numbers);
    return numbers.subList(FROM_INDEX, TO_INDEX);
  }
}
