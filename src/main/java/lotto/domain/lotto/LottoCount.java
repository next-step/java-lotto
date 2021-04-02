package lotto.domain.lotto;

import java.util.Objects;
import lotto.domain.Money;
import lotto.exception.NegativeLottoCountException;

public final class LottoCount {

  private final long lottoCount;

  public LottoCount(Money money) {
    this(0);
  }

  public LottoCount(long lottoCount) {
    validateNegativeCount(lottoCount);
    this.lottoCount = lottoCount;
  }

  private void validateNegativeCount(long lottoCount) {
    if (lottoCount < 0) {
      throw new NegativeLottoCountException();
    }
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

  public long getLottoCount() {
    return lottoCount;
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
}
