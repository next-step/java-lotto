package step2.domain.number;

import step2.exception.InvalidNumbersSizeException;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
  private final List<Number> numbers;

  private static final int STANDARD_SIZE = 6;
  private static final String SIZE_ERROR_MESSAGE = "숫자 개수가 일치하지 않습니다.";

  public Numbers(List<Number> numbers) {
    if (numbers.size() != STANDARD_SIZE) {
      throw new InvalidNumbersSizeException(SIZE_ERROR_MESSAGE);
    }
    this.numbers = numbers;
  }

  public List<Number> sort() {
    return numbers.stream().sorted(Number::compareTo).collect(Collectors.toList());
  }

  public Number matchNumbers(Numbers targetNumbers) {
    int result = targetNumbers.numbers.stream().filter(numbers::contains).mapToInt(e -> 1).sum();
    return new Number(result);
  }

  @Override
  public String toString() {
    return sort().toString();
  }
}
