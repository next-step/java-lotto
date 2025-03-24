package lotto.type;

import lotto.property.LottoProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoPrize {
  ZERO_MATCHES(0, LottoProperty.NO_PRIZE_AMOUNT),
  ONE_MATCHES(1, LottoProperty.NO_PRIZE_AMOUNT),
  TWO_MATCHES(2, LottoProperty.NO_PRIZE_AMOUNT),
  THREE_MATCHES(3, LottoProperty.FOURTH_PRIZE_AMOUNT),
  FOUR_MATCHES(4, LottoProperty.THIRD_PRIZE_AMOUNT),
  FIVE_MATCHES(5, LottoProperty.SECOND_PRIZE_AMOUNT),
  SIX_MATCHES(6, LottoProperty.FIRST_PRIZE_AMOUNT);

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
    return prizeAmount != LottoProperty.NO_PRIZE_AMOUNT;
  }

  @Override
  public String toString() {
    return String.format("%d개 일치 (%d원)", matchCount, prizeAmount);
  }
}
