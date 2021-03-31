package lotto.domain;

public class WinningBall {

  private final LottoBalls winLottoBalls;
  private final LottoBall bonusBall;

  public WinningBall(LottoBalls winLottoBalls, LottoBall bonusBall) {
    this.winLottoBalls = winLottoBalls;
    this.bonusBall = bonusBall;
  }

  public Ranking calculateRank(LottoBalls drawBalls) {
    int count = 0;
    count = drawBalls.countContainingWinNumbers(winLottoBalls);
    if (isNoMatchBonusSecond(drawBalls, count)) {
      return Ranking.SECOND;
    }
    return Ranking.ofCount(count);
  }

  private boolean isNoMatchBonusSecond(LottoBalls drawBalls, int count) {
    return count == 5 && !drawBalls.containBonusBall(bonusBall);
  }
}
