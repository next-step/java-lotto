package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {

  public static final int LOTTO_NUMBER_LIMIT_SIZE = 6;

  private final List<Number> numbers;

  public UserLotto(List<Number> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Number> numbers) {
    if (numbers.size() != LOTTO_NUMBER_LIMIT_SIZE) {
      throw new IllegalArgumentException();
    }
  }

  public List<Number> getNumbers() {
    return this.numbers;
  }

  @Override
  public String toString() {
    return numbers.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
