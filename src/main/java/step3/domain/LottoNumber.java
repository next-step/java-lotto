package step3.domain;
import step3.execption.InvalidRangeNumberException;

public class LottoNumber {

  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 45;
  private final int number;

  private LottoNumber (int number) {
    validateNumbers(number);
    this.number = number;
  }

  static public LottoNumber of (String number) {
    return of(Integer.parseInt(number));
  }

  static public LottoNumber of (int number) {
    return new LottoNumber(number);
  }

  public boolean equals(LottoNumber lottoNumber) {
    return lottoNumber.number == number;
  }

  private static void validateNumbers (int number) throws RuntimeException {
    if (number < MIN_VALUE || number > MAX_VALUE) {
      throw new InvalidRangeNumberException();
    }
  }

}
