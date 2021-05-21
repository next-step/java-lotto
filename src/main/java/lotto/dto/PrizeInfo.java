package lotto.dto;

import lotto.domain.LottoRanking;

import java.util.Objects;

public class PrizeInfo {

  private final int matchCountPerGame;
  private final long winningAmount;
  private final long winningCount;

  public PrizeInfo(LottoRanking lottoRanking, long winningCount) {
    this.matchCountPerGame = lottoRanking.matchCount();
    this.winningAmount = lottoRanking.winningAmount();
    this.winningCount = winningCount;
  }

  public int getMatchCountPerGame() {
    return matchCountPerGame;
  }

  public long getWinningAmount() {
    return winningAmount;
  }

  public long getWinningCount() {
    return winningCount;
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
