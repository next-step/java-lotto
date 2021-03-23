package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoBalls {

  private List<LottoBall> lottoBalls;

  public LottoBalls(List<LottoBall> lottoBalls) {
    this.lottoBalls = lottoBalls;
  }

  public List<LottoBall> draw() {
    Collections.shuffle(this.lottoBalls);
    List<LottoBall> lottoBalls = this.lottoBalls.subList(0, 6);
    Collections.sort(lottoBalls);
    return lottoBalls;
  }
}
