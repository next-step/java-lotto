package lotto.domain;

public class LottoNumber {

  public static final int LOTTO_MINIMUM_NUMBER = 1;
  public static final int LOTTO_MAXIMUM_NUMBER = 45;
  private static final String ILLEGAL_LOTTO_NUMBER_MESSAGE = "올바른 로또 번호를 입력해주세요. 입력된 번호 : ";
  private final int number;

  public LottoNumber(int number) {
    this.number = validatedLottoNumber(number);
  }

  public int number() {
    return number;
  }

  private int validatedLottoNumber(int number) {
    if (!isLottoNumber(number)) {
      throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE + number);
    }

    return number;
  }

  private boolean isLottoNumber(int number) {
    return number >= LOTTO_MINIMUM_NUMBER && number <= LOTTO_MAXIMUM_NUMBER;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LottoNumber that = (LottoNumber) o;

    return number == that.number;
  }

  @Override
  public int hashCode() {
    return number;
  }
}
