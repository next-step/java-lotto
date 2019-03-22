package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

  private static final int START_NUMBER = 1;
  private static final int END_NUMBER = 45;

  private static final int FROM_INDEX = 0;
  private static final int TO_INDEX = 6;

  public Set<Integer> generate() {

    List<Integer> numbers = IntStream.range(START_NUMBER, END_NUMBER)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(numbers);

    return new HashSet<>(numbers.subList(FROM_INDEX, TO_INDEX));
  }
}
