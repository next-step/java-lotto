package lotto.domain;

import java.util.Objects;
import lotto.domain.money.Money;

public class Statistic {

  private static final String NULL_PRIZE = "당첨금은 null일 수 없습니다.";
  private static final String NEGATIVE_MATCHED_PRICE_COUNT = "당첨 개수는 음수일 수 없습니다.";

  private final Prize prize;
  private final int matchedPrizeCount;

  public Statistic(int matchedPriceCount, Prize prize) {
    requireNonNegative(matchedPriceCount);
    Objects.requireNonNull(prize, NULL_PRIZE);
    this.matchedPrizeCount = matchedPriceCount;
    this.prize = prize;
  }

  private void requireNonNegative(int matchedPriceCount) {
    if (isNegative(matchedPriceCount)) {
      throw new IllegalArgumentException(NEGATIVE_MATCHED_PRICE_COUNT);
    }
  }

  private boolean isNegative(int matchedPriceCount) {
    return matchedPriceCount < 0;
  }

  public int getMatchedPrizeCount() {
    return matchedPrizeCount;
  }

  public int getMatchCount() {
    return prize.getMatchCount();
  }

  public Money getPrizeMoney() {
    return prize.getPrize();
  }

  public boolean isMatchBonus() {
    return prize.isMatchBonus();
  }

  public Money getTotalPrize() {
    return getPrizeMoney().multiply(getMatchedPrizeCount());
  }
}
