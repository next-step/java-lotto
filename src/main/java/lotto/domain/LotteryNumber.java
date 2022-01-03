package lotto.domain;

import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber> {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private static final String WRONG_VALUE_EXCEPTION = "The lottery's number is wrong value";

  private final int number;

  public LotteryNumber(int number) {
    validateOrThrow(number);
    this.number = number;
  }

  public static int minNumber() {
    return MIN_NUMBER;
  }

  public static int maxNumber() {
    return MAX_NUMBER;
  }

  public int getNumber() {
    return number;
  }

  private void validateOrThrow(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(WRONG_VALUE_EXCEPTION);
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
