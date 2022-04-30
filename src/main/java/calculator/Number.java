package calculator;

import java.util.Objects;

public final class Number {

  private final int number;

  public static Number from(String value) {
    return new Number(Integer.parseInt(value));
  }

  private Number(int number) {
    this.number = number;
  }

  int number() {
    return number;
  }

  Number add(Number target) {
    return new Number(number + target.number);
  }

  Number subtract(Number target) {
    return new Number(number - target.number);
  }

  Number multiply(Number target) {
    return new Number(number * target.number);
  }

  Number divide(Number target) {
    return new Number(number / target.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
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
    return this.number == number.number;
  }
}
