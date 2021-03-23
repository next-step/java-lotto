package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBallFactory {
  private static final int LOTTO_NUMBER = 45;

  private static List<LottoBall> lottoBallList = new ArrayList<>();

  public static void initialize() {
    for (int i=1 ; i <= LOTTO_NUMBER ; i++) {
      lottoBallList.add(LottoBall.create(i));
    }
  }

}
