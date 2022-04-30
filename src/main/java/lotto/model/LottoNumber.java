package lotto.model;

public class LottoNumber {

  private static final int LOTTO_NUMBER_RANGE_START = 1;
  private static final int LOTTO_NUMBER_RANGE_END = 45;

  private final int value;


  public LottoNumber(int value) {
    validateLottoNumber(value);
    this.value = value;
  }

  public static LottoNumber create(int value) {
    return new LottoNumber(value);
  }

  public static LottoNumber create(String winningLottoNumber) {
    return new LottoNumber(convertToNumber(winningLottoNumber));
  }

  public int getValue() {
    return this.value;
  }

  private void validateLottoNumber(int value) {
    if (value < LOTTO_NUMBER_RANGE_START || value > LOTTO_NUMBER_RANGE_END) {
      throw new IllegalArgumentException();
    }
  }

  private static int convertToNumber(String winningLottoNumber) {
    return Integer.parseInt(winningLottoNumber);
  }
}
