package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PositiveNumbers {
  private final List<Number> positiveNumbers;

  public PositiveNumbers(List<Number> positiveNumbers) {
    this.positiveNumbers = positiveNumbers;
  }

  public static PositiveNumbers create(Delimiter delimiter, NumberString numberString) {
    return new PositiveNumbers(Arrays.stream(numberString.getNumberString().split(delimiter.getDelimiter()))
            .map(Number::positiveValueOf)
            .collect(Collectors.toList()));
  }

  public Number sum() {
    return positiveNumbers.stream()
            .reduce(Number::sum)
            .orElse(Number.zero());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PositiveNumbers that = (PositiveNumbers) o;
    return Objects.equals(positiveNumbers, that.positiveNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(positiveNumbers);
  }
}
