package lotto.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoPrize {
  ZERO_MATCHES(0, 0),
  ONE_MATCHES(1, 0),
  TWO_MATCHES(2, 0),
  THREE_MATCHES(3, 5_000),
  FOUR_MATCHES(4, 50_000),
  FIVE_MATCHES(5, 1_500_000),
  SIX_MATCHES(6, 2_000_000_000);

  private static final Map<Integer, LottoPrize> MATCH_COUNT_TO_PRIZE_MAP = new HashMap<>();

  private final int matchCount;
  private final int prizeAmount;

  LottoPrize(int matchCount, int prizeAmount) {
    this.matchCount = matchCount;
    this.prizeAmount = prizeAmount;
  }

  static {
    for (LottoPrize prize : values()) {
      MATCH_COUNT_TO_PRIZE_MAP.put(prize.matchCount, prize);
    }
  }

  public static LottoPrize findByMatchCount(int count) {
    LottoPrize prize = MATCH_COUNT_TO_PRIZE_MAP.get(count);
    if (prize == null) {
      throw new IllegalArgumentException("No prize available for this match count: " + count);
    }
    return prize;
  }

  public static int getTotalPrize(List<LottoPrize> lottoPrizes) {
    return lottoPrizes.stream()
        .mapToInt(lottoPrize -> lottoPrize.prizeAmount)
        .sum();
  }

  public boolean hasPrize() {
    return prizeAmount != 0;
  }

  @Override
  public String toString() {
    return String.format("%d개 일치 (%d원)", matchCount, prizeAmount);
  }
}
