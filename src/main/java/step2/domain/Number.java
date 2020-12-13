package step2.domain;

public class Number {

  public static final int LOTTO_MIN_NUMBER = 1;
  public static final int LOTTO_MAX_NUMBER = 45;

  private final int number;

  public Number(int number) {
    validate(number);
    this.number = number;
  }

  private void validate(int number) {
    if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException();
    }
  }

  public Number(String number) {
    this.number = Integer.parseInt(number);
  }

  public int get() {
    return this.number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

}
