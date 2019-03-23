package lotto.domain;

public class LottoNumber {

  public final static int MINIMUM = 1;
  public final static int MAXIMUM = 45;

  private final int number;

  public LottoNumber(int number) {

    if (number < MINIMUM || number > MAXIMUM) {
      throw new IllegalArgumentException();
    }

    this.number = number;
  }

}
