package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final int generatedNumber;

  public Number(int generatedNumber) {
    validation(generatedNumber);
    this.generatedNumber = generatedNumber;
  }

  public static Number generateNumber(int generatedNumber) {
    return new Number(generatedNumber);
  }

  private void validation(int generatedNumber) {
    rangeValidate(generatedNumber);
  }

  private void rangeValidate(int generatedNumber) {
    if(generatedNumber < MIN_NUMBER || generatedNumber > MAX_NUMBER) {
      throw new IllegalArgumentException("ERROR : 해당 범위에는 생성하실 수 없습니다.");
    }
  }

  public int getNumber() {
    return generatedNumber;
  }

  @Override
  public int compareTo(Number number) {
    if (this.generatedNumber < number.getNumber()) {
      return -1;
    } else if (this.generatedNumber > number.generatedNumber) {
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.valueOf(generatedNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Number)) {
      return false;
    }
    Number number = (Number) o;
    return generatedNumber == number.generatedNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(generatedNumber);
  }
}
