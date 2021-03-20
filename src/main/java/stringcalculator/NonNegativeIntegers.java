package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonNegativeIntegers)) {
      return false;
    }
    NonNegativeIntegers that = (NonNegativeIntegers) o;
    return Objects.equals(numbers, that.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
