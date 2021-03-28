package lotto.domain;

import java.util.List;

public final class LottoGame {

  private final LottoBalls lottoBalls;

  public LottoGame(final LottoBalls lottoBalls) {
    this.lottoBalls = lottoBalls;
  }

  public String getLottoBallNumbersString() {
    return lottoBalls.toString();
  }

  public int countMatchNumber(LottoBalls winNumbers) {
    return lottoBalls.countContainingWinNumbers(winNumbers);
  }
}
