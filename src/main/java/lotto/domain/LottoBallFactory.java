package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBallFactory {
  private static final int LOTTO_NUMBER = 45;
  private static List<LottoBall> lottoBalls;

  public static void initialize() {
    lottoBalls = new ArrayList<>();
    for (int i=1 ; i <= LOTTO_NUMBER ; i++) {
      lottoBalls.add(LottoBall.create(i));
    }
  }

  public static List<LottoBall> draw() {
    Collections.shuffle(lottoBalls);
    List<LottoBall> ballsDraw = lottoBalls.subList(0, 6);
    Collections.sort(ballsDraw);
    return ballsDraw;
  }

}
