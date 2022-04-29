package lotto.domain.strategy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FixedNumberGenerator implements NumberGenerator {

  private final Iterator<Integer> numberIter;

  public FixedNumberGenerator(String numbers) {
    this.numberIter = toIntList(numbers).iterator();
  }

  @Override
  public int generate() {
    return numberIter.next();
  }

  private List<Integer> toIntList(String numbers) {
    return Arrays.stream(
            numbers.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
