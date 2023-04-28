package lotto.domain.round;

import java.util.Set;
import lotto.domain.game.LottoWinType;

public class LottoRound {
  private final int roundNo;
  private final Set<Integer> numbers;
  private final LottoRoundJudge roundJudge;

  public LottoRound (int roundNo, Set<Integer> numbers, LottoRoundJudge roundJudge) {
    this.roundNo = roundNo;
    this.numbers = numbers;
    this.roundJudge = roundJudge;
  }

  public LottoRoundResult playRound (Set<Integer> winningNumbers) {
    LottoWinType winType = roundJudge.judge(numbers, winningNumbers);
    return new LottoRoundResult(roundNo, winType);
  }
  public Set<Integer> getNumbers() {
    return numbers;
  }
}
