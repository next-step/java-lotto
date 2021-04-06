package lotto.domain;

import java.util.Objects;

public class LottoNumber {
  private final int lottoNumber;

  private LottoNumber(int lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  public static LottoNumber generate(int number) {
    LottoNumber newLottoNumber = new LottoNumber(number);
    if (!newLottoNumber.isValidNumberRange()) {
      throw new IllegalArgumentException("로또 번호는 1~45의 범위 안의 숫자여야만 한다.");
    }
    return newLottoNumber;
  }

  public boolean isValidNumberRange() {
    return 0 < lottoNumber && lottoNumber <= 45;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }
}
