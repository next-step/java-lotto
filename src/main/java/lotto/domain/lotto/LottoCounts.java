package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.exception.MoreManualLottoException;
import lotto.exception.NegativeLottoCountException;

public final class LottoCounts {

  private final long lottoCount;
  private final long manualCount;

  public LottoCounts(long lottoCount, long manualCount) {
    validateNegativeCount(lottoCount, manualCount);
    validateManualCount(lottoCount, manualCount);
    this.lottoCount = lottoCount;
    this.manualCount = manualCount;
  }

  private void validateNegativeCount(long lottoCount, long manualCount) {
    if (lottoCount < 0 || manualCount < 0) {
      throw new NegativeLottoCountException();
    }
  }

  private void validateManualCount(long lottoCount, long manualCount) {
    if (manualCount > lottoCount) {
      throw new MoreManualLottoException();
    }
  }

  public List<Lotto> automaticLottos() {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < lottoCount - manualCount; i++) {
      lottos.add(new Lotto());
    }
    return lottos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoCounts)) {
      return false;
    }
    LottoCounts that = (LottoCounts) o;
    return lottoCount == that.lottoCount && manualCount == that.manualCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoCount, manualCount);
  }
}
