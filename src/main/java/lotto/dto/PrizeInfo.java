package lotto.dto;

import lotto.domain.LottoRanking;

import java.util.Objects;

public class PrizeInfo {

  private static final String BONUS_BALL_NON_MATCHED_ANALYSIS_FORMAT = "%d개 일치 (%d원)- %d개";
  private static final String BONUS_BALL_MATCHED_ANALYSIS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";

  private final int matchCountPerGame;
  private final long winningAmount;
  private final boolean bonusNumberMatched;
  private final long winningCount;

  public PrizeInfo(LottoRanking lottoRanking, long winningCount) {
    this.matchCountPerGame = lottoRanking.getMatchCount();
    this.winningAmount = lottoRanking.getWinningAmount();
    this.bonusNumberMatched = lottoRanking.isBonusNumberMatched();
    this.winningCount = winningCount;
  }

  public long getWinningAmount() {
    return winningAmount;
  }

  public long getWinningCount() {
    return winningCount;
  }

  @Override
  public String toString() {
    if(bonusNumberMatched) {
      return String.format(BONUS_BALL_MATCHED_ANALYSIS_FORMAT, matchCountPerGame, winningAmount, winningCount);
    }
    return String.format(BONUS_BALL_NON_MATCHED_ANALYSIS_FORMAT, matchCountPerGame, winningAmount, winningCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PrizeInfo prizeInfo = (PrizeInfo) o;
    return matchCountPerGame == prizeInfo.matchCountPerGame && winningAmount == prizeInfo.winningAmount && winningCount == prizeInfo.winningCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchCountPerGame, winningAmount, winningCount);
  }
}
