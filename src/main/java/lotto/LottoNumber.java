package lotto;

import java.util.Objects;

public final class LottoNumber {

  private final int lottoNumber;

  public LottoNumber(int lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoNumber)) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }
}
