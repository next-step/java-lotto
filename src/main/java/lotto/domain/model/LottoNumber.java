package lotto.domain.model;

import static lotto.config.LottoGameConfig.LOTTO_MAX_NUMBER;
import static lotto.config.LottoGameConfig.LOTTO_MIN_NUMBER;
import static lotto.constants.Message.INPUT_SHOULD_INTEGER;
import static lotto.constants.Message.OVER_NUMBER_RANGE;

import java.util.Objects;
import lotto.exception.LottoGameException;

public class LottoNumber implements Comparable<LottoNumber> {

  private int number;

  public LottoNumber(int number) {
    this.number = validateLottoNumber(number);
  }

  public LottoNumber(String number) {
    this.number = validateLottoNumber(number);
  }

  private int validateLottoNumber(String number) {
    try {
      return validateLottoNumber(Integer.parseInt(number));
    } catch (NumberFormatException e) {
      throw new LottoGameException(INPUT_SHOULD_INTEGER, e);
    }
  }

  private int validateLottoNumber(int number) {
    if (!isValidRange(number)) {
      throw new LottoGameException(OVER_NUMBER_RANGE);
    }
    return number;
  }

  private boolean isValidRange(int number) {
    return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
  }

  @Override
  public int compareTo(LottoNumber o) {
    return this.number - o.number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
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
    return Objects.hash(number);
  }
}
