package calculator;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Numbers {

  private List<String> numbers;

  public Numbers(List<String> numbers) {
    this.numbers = trim(numbers);
  }

  public int sum() {
    return numbers.stream()
        .map(Integer::valueOf)
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
