package step1.domain;

import static step1.constans.RxPattern.DEFAULT_DELIMITER_PATTERN;

import java.util.Objects;
import step1.domain.model.Numbers;

public class DefaultOperation implements Operation {

  private final Numbers numbers;

  public DefaultOperation(String input) {
    this.numbers = new Numbers(input, DEFAULT_DELIMITER_PATTERN);
  }

  @Override
  public int sum() {
    return numbers.sum().intValue();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultOperation that = (DefaultOperation) o;
    return numbers.equals(that.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
