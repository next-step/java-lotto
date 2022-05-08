package lotto;

import static java.util.stream.IntStream.range;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

  public static final int FROM_INDEX = 0;
  public static final int TO_INDEX = 6;
  public static final int START_INCLUSIVE = 1;
  public static final int END_EXCLUSIVE = 46;

  public List<Integer> generate() {
    List<Integer> numbers = range(START_INCLUSIVE, END_EXCLUSIVE).boxed()
        .collect(Collectors.toList());
    Collections.shuffle(numbers);
    return numbers.subList(FROM_INDEX, TO_INDEX);
  }
}
