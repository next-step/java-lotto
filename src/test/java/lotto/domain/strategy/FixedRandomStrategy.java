package lotto.domain.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedRandomStrategy implements RandomStrategy {

  private int count = 1;

  @Override
  public List<Integer> getRandomNumbers() {
    return IntStream.rangeClosed(count, count++ + 5)
        .boxed()
        .collect(Collectors.toList());
  }
}
