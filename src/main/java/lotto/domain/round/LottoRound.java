package lotto.domain.round;

import java.util.List;
import lotto.domain.game.LottoWinType;
import lotto.domain.game.LottoWinningNumber;

public class LottoRound {
  private final LottoRoundNumbers roundNumbers;
  private final LottoRoundJudge roundJudge;

  public LottoRound (LottoRoundNumbers roundNumbers, LottoRoundJudge roundJudge) {
    this.roundNumbers = roundNumbers;
    this.roundJudge = roundJudge;
  }

  public LottoRoundResult playRound (LottoWinningNumber winningNumber) {
    LottoWinType winType = roundJudge.judge(roundNumbers, winningNumber);
    return new LottoRoundResult(winType);
  }

  public List<Integer> getRoundNumbers() {
    return roundNumbers.getNumbers();
  }
}
