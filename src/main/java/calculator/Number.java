package calculator;

import calculator.enums.Sign;
import java.util.Collections;
import java.util.Objects;

public class Number {

  private final int value;

  public Number(int value) {
    this.value = value;
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

  public Number arithmetic(String operation, Integer otherNumber) {
    return new Number(Sign.search(operation).execute(this.value, otherNumber));
  }

  public int getValue() {
    return this.value;
  }
}
