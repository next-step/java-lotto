package lotto.domain.round;

import java.util.List;
import lotto.domain.game.LottoWinType;

public class LottoRound {
  private final int roundNo;
  private final LottoRoundNumbers roundNumbers;
  private final LottoRoundJudge roundJudge;

  public LottoRound (int roundNo, List<Integer> numbers, LottoRoundJudge roundJudge, boolean distinctNumberOnly) {
    this.roundNo = roundNo;
    this.roundNumbers = new LottoRoundNumbers(numbers, distinctNumberOnly);
    this.roundJudge = roundJudge;
  }

  public LottoRoundResult playRound (List<Integer> winningNumbers) {
    LottoWinType winType = roundJudge.judge(getRoundNumbers(), winningNumbers);
    return new LottoRoundResult(roundNo, winType);
  }

  public List<Integer> getRoundNumbers() {
    return roundNumbers.getNumbers();
  }
}
