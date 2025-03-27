package lotto.type;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
  ZERO_MATCHES(0, 0),
  ONE_MATCHES(1, 0),
  TWO_MATCHES(2, 0),
  THREE_MATCHES(3, 5_000),
  FOUR_MATCHES(4, 50_000),
  FIVE_MATCHES(5, 1_500_000),
  FIVE_WITH_BONUS_MATCHES(5, 30_000_000),
  SIX_MATCHES(6, 2_000_000_000);

  private final int matchCount;
  private final int prizeAmount;

  private boolean hasMatchCount(int matchCount) {
    return this.matchCount == matchCount;
  }

  LottoPrize(int matchCount, int prizeAmount) {
    this.matchCount = matchCount;
    this.prizeAmount = prizeAmount;
  }

  public static LottoPrize findByMatchCount(int matchCount, boolean matchBonus) {
    if (matchCount == 5) {
      return matchBonus ? FIVE_WITH_BONUS_MATCHES : FIVE_MATCHES;
    }

    return Arrays.stream(values())
        .filter(lottoPrize -> lottoPrize.hasMatchCount(matchCount))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 일치 수입니다."));
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
