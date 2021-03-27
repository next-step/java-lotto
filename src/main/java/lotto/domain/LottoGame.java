package lotto.domain;

import java.util.List;

public class LottoGame {
  private static final int SIX = 6;

  private final LottoBalls lottoBalls;

  public LottoGame(LottoBalls lottoBalls) {
    if (lottoBalls.size() != SIX) {
      throw new IllegalArgumentException("로또 공 개수가 6개가 아닙니다.");
    }
    this.lottoBalls = lottoBalls;
  }

  public String getLottoBallNumbersString() {
    return lottoBalls.numbersString();
  }

  public int countMatchNumber(List<LottoBall> winNumbers) {
    return lottoBalls.countContainingWinNumbers(winNumbers);
  }
}
