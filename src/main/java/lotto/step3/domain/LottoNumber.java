package lotto.step3.domain;
import lotto.step3.execption.InvalidRangeNumberException;

public class LottoNumber implements Comparable<LottoNumber> {

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

  public int getNumber () {
    return number;
  }

  @Override
  public boolean equals(Object lottoNumber) {
    if (this == lottoNumber) {
      return true;
    }
    if (!(lottoNumber instanceof LottoNumber)) {
      return false;
    }
    return number == ((LottoNumber)lottoNumber).number;
  }

  private static void validateNumbers (int number) throws RuntimeException {
    if (number < MIN_VALUE || number > MAX_VALUE) {
      throw new InvalidRangeNumberException();
    }
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    return number - lottoNumber.number;
  }

}
