package calculator;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Numbers {

  private List<Integer> numbers;

  public Numbers(List<String> numbers) {
    this.numbers = initNumbers(numbers);
    validateNumber(this.numbers);
  }

  private List<Integer> initNumbers(List<String> numbers) {
    return trim(numbers).stream()
        .map(Integer::valueOf)
        .collect(toList());
  }

  private void validateNumber(List<Integer> numbers) {
    if (isNegative(numbers)) {
      throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
    }
  }

  private boolean isNegative(List<Integer> numbers) {
    return numbers.stream()
        .anyMatch(i -> i < 0);
  }

  public int sum() {
    return numbers.stream()
        .reduce(0, Integer::sum);
  }

  private List<String> trim(List<String> numbers) {
    return numbers.stream()
        .map(String::trim)
        .collect(toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Numbers numbers1 = (Numbers) o;
    return Objects.equals(numbers, numbers1.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
