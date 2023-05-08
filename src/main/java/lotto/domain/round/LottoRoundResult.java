package lotto.domain.round;

import lotto.domain.game.LottoWinType;

public class LottoRoundResult {

  private final LottoWinType winType;

  public LottoRoundResult (LottoWinType winType) {
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
