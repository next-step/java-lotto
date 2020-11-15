package lotto;

import static lotto.LottoConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoConstant.MINIMUM_LOTTO_NUMBER;

import java.util.Objects;
import lotto.lottoexception.IllegalLottoNumberRange;

public class LottoNumber {

  private final int number;

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber of(int number) {
    validateNumber(number);
    return new LottoNumber(number);
  }

  private static void validateNumber(int number) {
    if (!(MINIMUM_LOTTO_NUMBER <= number && number <= MAXIMUM_LOTTO_NUMBER)) {
      throw new IllegalLottoNumberRange();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return this.number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.number);
  }

  @Override
  public String toString() {
    return String.valueOf(this.number);
  }
}
