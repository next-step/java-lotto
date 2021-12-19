package lotto.domain;

public class LotteryNumber {

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
      throw new IllegalArgumentException(String.valueOf(number));
    }
  }
}
