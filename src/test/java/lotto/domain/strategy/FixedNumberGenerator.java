package lotto.domain.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedNumberGenerator implements NumberGenerator {

  private final List<Integer> numbers;

  public FixedNumberGenerator(String numbers) {
    this.numbers = toIntList(numbers);
  }

  @Override
  public List<Integer> generate() {
    return numbers;
  }

  private List<Integer> toIntList(String numbers) {
    return Arrays.stream(
            numbers.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
