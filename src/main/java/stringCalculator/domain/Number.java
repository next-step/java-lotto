package stringCalculator.domain;

import java.util.Objects;

public class Number {
  private int number;

  public Number(String numberString) {
    if ( numberString == null || "".equals(numberString))
      numberString = "0";

    int numberParsed = Integer.parseInt(numberString);
    if ( numberParsed < 0)
      throw new RuntimeException("음수입니다");

    this.number = numberParsed;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number1 = (Number) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
