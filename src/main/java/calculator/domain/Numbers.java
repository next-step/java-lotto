package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

  private final List<Integer> values;

  public Numbers(List<Integer> values) {
    this.values = values;
  }

  public static Numbers of(List<String> value) {
    try {
      List<Integer> numbers = value.stream()
          .map(Integer::valueOf)
          .collect(Collectors.toList());
      return new Numbers(numbers);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("계산식에 오류가 있습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Numbers numbers = (Numbers) o;
    return Objects.equals(values, numbers.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
