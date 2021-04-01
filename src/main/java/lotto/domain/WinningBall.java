package lotto.domain;

public class WinningBall {

  private final LottoBalls winLottoBalls;
  private final LottoBall bonusBall;

  public WinningBall(LottoBalls winLottoBalls, LottoBall bonusBall) {
    this.winLottoBalls = winLottoBalls;
    this.bonusBall = bonusBall;
  }

  public Ranking calculateRank(LottoBalls drawBalls) {
    int count = drawBalls.countContainingWinNumbers(winLottoBalls);
    return Ranking.find(count, drawBalls.containBonusBall(bonusBall));
  }
}
