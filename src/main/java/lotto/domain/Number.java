package lotto.domain;

import java.util.Objects;

public class Number {

  private int value;

  public Number(int value) {
    this.value = value;
  }

  public Number(String value) {
    this.value = Integer.parseInt(value.trim());
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

  @Override
  public String toString() {
    return value + "";
  }
}
