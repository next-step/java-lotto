package step2.domain;

public class Number {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final String ERROR_MESSAGE = "%d은(는) 로또 범위 숫자가 아닙니다.";


  private final int number;

  public Number(int number) {
    validate(number);
    this.number = number;
  }

  private void validate(int number) {
    if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE, number));
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
