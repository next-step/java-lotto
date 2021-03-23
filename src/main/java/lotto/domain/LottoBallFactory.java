package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBallFactory {
  private static final int LOTTO_NUMBER = 45;

  public static LottoBalls initialize() {
    List<LottoBall> lottoBalls = new ArrayList<>();
    for (int i=1 ; i <= LOTTO_NUMBER ; i++) {
      lottoBalls.add(LottoBall.create(i));
    }
    return new LottoBalls(lottoBalls);
  }

}
