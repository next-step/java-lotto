package lotto.domain.lotto;

import java.util.Objects;

public final class LottoCount {

  private final long lottoCount;
  private final long manualCount;

  public LottoCount(long lottoCount, long manualCount) {
    this.lottoCount = lottoCount;
    this.manualCount = manualCount;
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
