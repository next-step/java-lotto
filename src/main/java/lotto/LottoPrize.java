package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoPrize {
  private static final Map<Integer, Integer> prize;

  static {
    prize = new HashMap<>();
    prize.put(3, 5000);
    prize.put(4, 50000);
    prize.put(5, 1500000);
    prize.put(6, 2000000000);
  }

  public static int getPrize(int matchCount) {
    return prize.get(matchCount);
  }
}
