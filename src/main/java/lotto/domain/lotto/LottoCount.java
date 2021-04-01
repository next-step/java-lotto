package lotto.domain.lotto;

import java.util.Objects;
import lotto.exception.NegativeLottoCountException;

public final class LottoCount {

  private final long lottoCount;

  public LottoCount(long lottoCount) {
    validateNegativeCount(lottoCount);
    this.lottoCount = lottoCount;
  }

  private void validateNegativeCount(long lottoCount) {
    if (lottoCount < 0) {
      throw new NegativeLottoCountException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoCount)) {
      return false;
    }
    LottoCount that = (LottoCount) o;
    return lottoCount == that.lottoCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoCount);
  }

  public boolean isBiggerThan(LottoCount other) {
    return lottoCount > other.lottoCount;
  }

  public LottoCount subtract(LottoCount other) {
    return new LottoCount(lottoCount - other.lottoCount);
  }

  public int toInteger() {
    return (int) lottoCount;
  }
}
