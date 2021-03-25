package lotto.domain;

import java.util.Objects;

public final class LottoNumber {

  public static final String ILLEGAL_LOTTO_NUMBER = "유효한 로또 번호가 아닙니다.";

  private final int lottoNumber;

  public LottoNumber(int lottoNumber) {
    if (lottoNumber < 1 || lottoNumber > 45) {
      throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER);
    }
    this.lottoNumber = lottoNumber;
  }

  public String toStringValue() {
    return String.valueOf(lottoNumber);
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
