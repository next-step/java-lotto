package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBallMachine {
  private static final int LOTTO_NUMBER = 45;
  private List<LottoBall> lottoBalls;

  public void initialize() {
    lottoBalls = new ArrayList<>();
    for (int i=1 ; i <= LOTTO_NUMBER ; i++) {
      lottoBalls.add(new LottoBall(i));
    }
  }

  public List<LottoBall> draw() {
    Collections.shuffle(lottoBalls);
    List<LottoBall> ballsDraw = new ArrayList<>(lottoBalls.subList(0, 6));
    Collections.sort(ballsDraw);
    return ballsDraw;
  }

}
