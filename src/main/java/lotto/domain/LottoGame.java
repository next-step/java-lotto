package lotto.domain;

import java.util.List;

public class LottoGame {

  private List<LottoBall> balls;

  public void start(LottoBalls lottoBalls) {
     this.balls = lottoBalls.draw();
  }

}
