package lotto.domain;

import lotto.constant.Constant;

public class LottoNumber implements Comparable<LottoNumber> {

  private final int number;

  public LottoNumber(int number) {
    validateRange(number);
    this.number = number;
  }

  public int getLottoNumber() {
    return number;
  }

  public void validateRange(int number) {
    if (number > Constant.MAX_NUM || number < Constant.MIN_NUM) {
      throw new IllegalArgumentException("로또 번호는 1에서 45 사이 값만 가합니다.");
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

    return number == that.number;
  }

  @Override
  public int hashCode() {
    return number;
  }

  @Override
  public int compareTo(LottoNumber o) {
    if (this.number < o.number) {
      return -1;
    }
    if (this.number > o.number) {
      return 1;
    }
    return 0;
  }
}
