package lotto.domain;

import java.util.List;

public final class LottoGame {

  private final int manualTryCount;
  private final int autoTryCount;
  private final List<LottoBalls> lottoBallsList;

  public LottoGame(
      final int manualTryCount, final int autoTryCount, final List<LottoBalls> lottoBallsList) {
    this.manualTryCount = manualTryCount;
    this.autoTryCount = autoTryCount;
    this.lottoBallsList = lottoBallsList;
  }

  public int getManualTryCount() {
    return manualTryCount;
  }

  public int getAutoTryCount() {
    return autoTryCount;
  }

  public Statistics selectPrizeWinning(WinningBall winBalls) {
    Statistics statistics = new Statistics();
    for (LottoBalls lottoBalls : lottoBallsList) {
      Ranking ranking = winBalls.calculateRank(lottoBalls);
      statistics.recordRanking(ranking);
    }
    return statistics;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (LottoBalls lottoBalls : lottoBallsList) {
      builder.append("[");
      builder.append(lottoBalls.toString());
      builder.append("]");
      builder.append("\n");
    }
    return builder.toString();
  }

}
