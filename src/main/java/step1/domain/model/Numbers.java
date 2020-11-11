package step1.domain.model;

import static step1.domain.Number.ZERO_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import step1.domain.Number;

public class Numbers {

  private List<Number> numbers;

  public Numbers(String inputValue, Pattern delimiter) {
    this.numbers = toNumbersFromInputValue(inputValue, delimiter);
  }

  //for test
  public Numbers(List<Number> numbers) {
    this.numbers = numbers;
  }

  private List<Number> toNumbersFromInputValue(String inputValue, Pattern delimiter) {
    return Arrays.stream(delimiter.split(inputValue))
        .map(Number::new)
        .collect(Collectors.toList());
  }

  public Number sum() {
    return numbers.stream().reduce(ZERO_NUMBER, Number::sum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Numbers numbers1 = (Numbers) o;
    return numbers.equals(numbers1.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
