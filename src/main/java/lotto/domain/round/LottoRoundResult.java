package lotto.domain.round;

import lotto.domain.game.LottoWinType;

public class LottoRoundResult {

  private final int roundNo;
  private final LottoWinType winType;

  public LottoRoundResult (int roundNo, LottoWinType winType) {
    this.roundNo = roundNo;
    this.winType = winType;
  }

  public LottoWinType getWinType() {
    return winType;
  }

  public int getWinningPrize() {
    if (this.winType == null) {
      return 0;
    }
    return winType.getPrize();
  }
}
