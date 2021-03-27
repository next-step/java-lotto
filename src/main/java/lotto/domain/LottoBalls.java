package lotto.domain;

import java.util.List;

public final class LottoBalls {

  private List<LottoBall> lottoBalls;

  public LottoBalls(final List<LottoBall> lottoBalls) {
    this.lottoBalls = lottoBalls;
  }

  public int size() {
    return lottoBalls.size();
  }

  public String numbersString() {
    return lottoBalls.stream()
        .map(ball -> String.valueOf(ball.getNumber()))
        .reduce((d1, d2) -> String.join(",", d1,d2))
        .orElseThrow(() -> new IllegalArgumentException("로또 번호 문자열 변환 실패"));
  }

  public int countContainingWinNumbers(List<LottoBall> winLottoBalls) {
    int count=0;
    for (LottoBall winBall : winLottoBalls) {
      count = lottoBalls.contains(winBall) ? count + 1 : count;
    }
    return count;
  }
}
