package lotto.domain.lotto;

import java.util.Objects;

public final class LottoCount {

  private final long lottoCount;

  public LottoCount(long lottoCount) {
    this.lottoCount = lottoCount;
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
