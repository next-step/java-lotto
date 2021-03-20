package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NonNegativeIntegers {

  private final List<NonNegativeInteger> numbers;

  public NonNegativeIntegers(String[] numbers) {
    this(Arrays.stream(numbers)
        .map(NonNegativeInteger::new)
        .collect(Collectors.toList()));
  }

  public NonNegativeIntegers(List<NonNegativeInteger> numbers) {
    this.numbers = numbers;
  }

  public NonNegativeInteger sum() {
    NonNegativeInteger total = new NonNegativeInteger();
    for (NonNegativeInteger number : numbers) {
      total = total.sum(number);
    }
    return total;
  }
}
