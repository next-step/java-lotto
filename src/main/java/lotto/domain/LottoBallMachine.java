package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBallMachine {
  private List<LottoBall> lottoBalls;

  public void initialize() {
    lottoBalls = new ArrayList<>(LottoBall.values());
  }

  public List<LottoBall> draw() {
    Collections.shuffle(lottoBalls);
    List<LottoBall> ballsDraw = new ArrayList<>(lottoBalls.subList(0, 6));
    Collections.sort(ballsDraw);
    return ballsDraw;
  }

}
