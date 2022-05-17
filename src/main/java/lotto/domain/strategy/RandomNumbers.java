package lotto.domain.strategy;

import static java.util.stream.IntStream.rangeClosed;
import static lotto.domain.LottoConstants.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_START_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers implements GenerateNumbersStrategy {

  private static final int FROM_INDEX = 0;
  private static final int TO_INDEX = 6;

  public List<Integer> generate() {
    List<Integer> numbers = rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER).boxed()
        .collect(Collectors.toList());
    Collections.shuffle(numbers);
    return numbers.subList(FROM_INDEX, TO_INDEX);
  }
}
