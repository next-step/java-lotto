package lotto.domain;

import static java.lang.Integer.parseInt;

import java.util.Objects;

public class ManualNumber {

  private final int number;

  public ManualNumber(String number) {
    this(parseInt(number));
  }

  public ManualNumber(int number) {
    this.number = number;
  }

  public int number() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManualNumber that = (ManualNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
