package lotto.domain;

import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber> {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final int number;

  public LotteryNumber(int number) {
    validate(number);
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public static int getMinNumber() {
    return MIN_NUMBER;
  }

  public static int getMaxNumber() {
    return MAX_NUMBER;
  }

  private void validate(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException("The lottery's number is wrong value");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LotteryNumber that = (LotteryNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public int compareTo(LotteryNumber o) {
    return this.number - o.number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
