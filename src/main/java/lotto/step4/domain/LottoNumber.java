package lotto.step4.domain;

import lotto.step4.execption.InvalidRangeNumberException;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 45;
  private static LottoNumber[] FACTORY = new LottoNumber[45];

  private final int number;

  private LottoNumber (int number) {
    this.number = number;
  }

  private static void validateNumbers (int number) throws RuntimeException {
    if (number < MIN_VALUE || number > MAX_VALUE) {
      throw new InvalidRangeNumberException();
    }
  }

  static public LottoNumber valueOf(String number) {
    return valueOf(Integer.parseInt(number));
  }

  static public LottoNumber valueOf(int number) {
    validateNumbers(number);
    int index = number - 1;
    if (FACTORY[index] != null) {
      return FACTORY[index];
    }
    FACTORY[index] = new LottoNumber(number);
    return FACTORY[index];
  }

  public int getNumber () {
    return number;
  }

  @Override
  public boolean equals(Object lottoNumber) {
    return this == lottoNumber;
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    return number - lottoNumber.number;
  }

}
