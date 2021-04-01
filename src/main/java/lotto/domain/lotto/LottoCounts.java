package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.exception.MoreManualLottoException;

public final class LottoCounts {

  private final LottoCount lottoCount;
  private final LottoCount manualCount;

  public LottoCounts(LottoCount lottoCount, LottoCount manualCount) {
    validateManualCount(lottoCount, manualCount);
    this.lottoCount = lottoCount;
    this.manualCount = manualCount;
  }

  private void validateManualCount(LottoCount lottoCount, LottoCount manualCount) {
    if (manualCount.isBiggerThan(lottoCount)) {
      throw new MoreManualLottoException();
    }
  }

  public List<Lotto> automaticLottos() {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < lottoCount.subtract(manualCount).toInteger(); i++) {
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
    return Objects.equals(lottoCount, that.lottoCount) && Objects
        .equals(manualCount, that.manualCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoCount, manualCount);
  }
}
