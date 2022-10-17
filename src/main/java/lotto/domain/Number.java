package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private final int number;

  private Number(int number) {
    this.number = number;
  }

  public static Number from(int number) {
    if (MIN_NUMBER > number || MAX_NUMBER < number) {
      throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 생성이 가능합니다");
    }
    return new Number(number);
  }

  public int getNumber() {
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
    Number number1 = (Number) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

  @Override
  public int compareTo(Number o) {
    return number - o.getNumber();
  }
}
