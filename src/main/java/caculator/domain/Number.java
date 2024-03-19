package caculator.domain;

import java.util.Objects;

public final class Number {
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

  public Number apply(Operator operator, Number operand) {
    return operator.operate(this, operand);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Number number = (Number) o;
    return this.value == number.value;
  }

  public boolean equals(int target) {
    return this.equals(new Number(target));
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
