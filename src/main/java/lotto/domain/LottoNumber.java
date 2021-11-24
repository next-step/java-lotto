package lotto.domain;

public class LottoNumber {

  private static final String NOT_VALID_LOTTO_NUMBER_ERROR = "유효한 로또 번호가 아닙니다.";
  private static final int LOTTO_MAX_NUMBER = 45;

  private final int number;

  public LottoNumber (int number) {
    if (number > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException(NOT_VALID_LOTTO_NUMBER_ERROR);
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
  }
}
