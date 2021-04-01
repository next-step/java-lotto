package lotto.domain.lotto;

import java.util.Objects;
import lotto.exception.NegativeLottoCountException;

public final class LottoCount {

  private final long lottoCount;
  private final long manualCount;

  public LottoCount(long lottoCount, long manualCount) {
    validateNegativeCount(lottoCount, manualCount);
    this.lottoCount = lottoCount;
    this.manualCount = manualCount;
  }

  private void validateNegativeCount(long lottoCount, long manualCount) {
    if (lottoCount < 0 || manualCount < 0) {
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
    return lottoCount == that.lottoCount && manualCount == that.manualCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoCount, manualCount);
  }
}
