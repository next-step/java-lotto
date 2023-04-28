package stringCalculator;

import java.util.Objects;

public class Number {
  private final int value;

  public Number(int value) {
    this.value = value;
  }

  public Number(String value) {
    this(Integer.parseInt(value));
  }

  public int value() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number = (Number) o;
    return value == number.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
