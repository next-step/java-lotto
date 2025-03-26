package lotto.type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPrize {
  ZERO_MATCHES(0, 0),
  ONE_MATCHES(1, 0),
  TWO_MATCHES(2, 0),
  THREE_MATCHES(3, 5_000),
  FOUR_MATCHES(4, 50_000),
  FIVE_MATCHES(5, 1_500_000),
  FIVE_WITH_BONUS_MATCHES(5, 1_500_000),
  SIX_MATCHES(6, 2_000_000_000);

  private final int matchCount;
  private final int prizeAmount;

  LottoPrize(int matchCount, int prizeAmount) {
    this.matchCount = matchCount;
    this.prizeAmount = prizeAmount;
  }

  public static LottoPrize findByMatchCount(int matchCount, boolean matchBonus) {
    List<LottoPrize> prizes = Arrays.stream(values())
        .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
        .collect(Collectors.toList());

    if (prizes.isEmpty()) {
      throw new IllegalArgumentException("No prize available for this match count: " + matchCount);
    }

    if (prizes.size() == 1) {
      return prizes.get(0);
    }

    if (!(prizes.contains(FIVE_MATCHES) && prizes.contains(FIVE_WITH_BONUS_MATCHES) && prizes.size() == 2)) {
      throw new IllegalStateException("fail to get lotto prizes");
    }

    return matchBonus ? FIVE_WITH_BONUS_MATCHES : FIVE_MATCHES;
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
