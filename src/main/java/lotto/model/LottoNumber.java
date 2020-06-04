package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  private final int number;
  private final boolean isBonusNumber;

  public LottoNumber(int number, boolean isBonusNumber) {
    checkLottoNumberRange(number);

    this.number = number;
    this.isBonusNumber = isBonusNumber;
  }

  private void checkLottoNumberRange(int number) {
    if (!LottoNumberPool.getInstance().getNumbers().contains(number)) {
      throw new IllegalArgumentException("로또 숫자는 1~45 사이로 입력되어야 합니다.");
    }
  }

  @Override
  public int compareTo(LottoNumber target) {
    return Integer.compare(this.number, target.number);
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
    return number == that.number &&
        isBonusNumber == that.isBonusNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, isBonusNumber);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
