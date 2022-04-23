package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {

  private final List<Integer> values;

  public Numbers(List<Integer> values) {
    this.values = values;
  }

  public static Numbers of(List<String> input) {
    validateInputSize(input);
    List<Integer> numbers = new ArrayList<>();

    return new Numbers(numbers);
  }

  private static void validateInputSize(List<String> input) {
    if (input.size() % 2 == 0) {
      throw new IllegalArgumentException("올바른 문자열을 입력해주세요.");
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
