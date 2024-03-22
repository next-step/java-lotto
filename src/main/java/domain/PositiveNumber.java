package domain;

import java.awt.*;
import java.util.Objects;

public final class PositiveNumber {
  private final int value;

  public static PositiveNumber of(final int value) {
    return new PositiveNumber(value);
  }

  public static PositiveNumber of(final Integer value) {
    return new PositiveNumber(value);
  }

  private PositiveNumber(final int value) {
    if (value < 0) {
      throw new IllegalArgumentException("Wrong constructor argument!");
    }
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public boolean lessThan(final PositiveNumber number) {
    return this.value < number.value;
  }

  public boolean greaterThan(final PositiveNumber number) {
    return this.value > number.value;
  }

  public boolean greaterOrEqual(final PositiveNumber number) {
    return this.value >= number.value;
  }

  public PositiveNumber quotient(final PositiveNumber number) {
    return new PositiveNumber(this.value / number.value);
  }

  public PositiveNumber quotient(final int number) {
    return this.quotient(PositiveNumber.of(number));
  }

  public PositiveNumber increment() {
    return new PositiveNumber(this.value + 1);
  }

  public PositiveNumber sum(PositiveNumber number) {
    return new PositiveNumber(this.value + number.value);
  }

  public PositiveNumber sum(int number) {
    return new PositiveNumber(this.value + number);
  }

  public PositiveNumber subtract(int number) {
    return new PositiveNumber(this.value - number);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PositiveNumber that = (PositiveNumber) o;
    return value == that.value;
  }

  public boolean equals(int number) {
    return this.equals(new PositiveNumber(number));
  }

  public boolean equals(Integer number) {
    return this.equals(new PositiveNumber(number));
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "PositiveNumber{" +
            "value=" + this.value + '\'' +
            "}";
  }
}
