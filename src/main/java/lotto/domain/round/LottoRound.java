package lotto.domain.round;

import java.util.List;
import lotto.domain.game.LottoGameType;
import lotto.domain.game.LottoWinType;
import lotto.domain.game.LottoWinningNumber;

public class LottoRound {
  private final int roundNo;
  private final LottoRoundNumbers roundNumbers;
  private final LottoRoundJudge roundJudge;

  private final LottoGameType gameType;

  public LottoRound (int roundNo, LottoRoundNumbers roundNumbers, LottoRoundJudge roundJudge, LottoGameType gameType) {
    this.roundNo = roundNo;
    this.roundNumbers = roundNumbers;
    this.roundJudge = roundJudge;
    this.gameType = gameType;
  }

  public static LottoRound ofAuto (int roundNo, LottoRoundNumbers roundNumbers, LottoRoundJudge roundJudge) {
    return new LottoRound(roundNo, roundNumbers, roundJudge, LottoGameType.AUTO);
  }

  public static LottoRound ofManual(int roundNo, LottoRoundNumbers roundNumbers, LottoRoundJudge roundJudge) {
    return new LottoRound(roundNo, roundNumbers, roundJudge, LottoGameType.MANUAL);
  }

  public LottoRoundResult playRound (LottoWinningNumber winningNumber) {
    LottoWinType winType = roundJudge.judge(roundNumbers, winningNumber);
    return new LottoRoundResult(roundNo, winType);
  }

  public List<Integer> getRoundNumbers() {
    return roundNumbers.getNumbers();
  }

  public LottoGameType getGameType() {
    return gameType;
  }
}
