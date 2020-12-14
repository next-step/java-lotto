package step2.domain.result;

import step2.enums.LottoWinningEnum;

public class WinningMatchResult {
  private final LottoWinningEnum lottoWinningEnum;
  private final long lottoMatchSize;

  public WinningMatchResult(LottoWinningEnum lottoWinningEnum, long lottoMatchSize) {
    this.lottoWinningEnum = lottoWinningEnum;
    this.lottoMatchSize = lottoMatchSize;
  }

  public LottoWinningEnum getLottoWinningEnum() {
    return lottoWinningEnum;
  }

  public long getLottoMatchSize() {
    return lottoMatchSize;
  }
}
