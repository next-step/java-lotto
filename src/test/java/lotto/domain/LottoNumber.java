package lotto.domain;

public class LottoNumber {
  private final int value;
  private final static int MIN = 1;
  private final static int MAX = 50;

  public LottoNumber(int value) {

    this.value = value;
  }

  public LottoNumber(String value) {
    this.value = value;
  }
}
