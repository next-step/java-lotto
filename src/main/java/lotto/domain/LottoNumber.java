package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_START_NUMBER;

import java.util.Objects;

public class LottoNumber {

  private final Integer number;

  public LottoNumber(Integer number) {
    validate(number);
    this.number = number;
  }

  public Integer getNumber() {
    return number;
  }

  private void validate(Integer number) {
    if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
      throw new IllegalArgumentException(String.format("%d 로또번호 범위가 올바르지 않습니다.", number));
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
    return Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
