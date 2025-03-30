package lotto;

import lotto.domain.LottoPrize;

import java.util.Arrays;
import java.util.Optional;

public class LottoPrizeMatcher {

  public static Optional<LottoPrize> findPrize(int matchCount, boolean isBonus) {
    return Arrays.stream(LottoPrize.values())
            .filter(prize -> isMatchingPrize(prize, matchCount, isBonus))
            .findFirst();
  }

  private static boolean isMatchingPrize(LottoPrize prize, int matchCount, boolean isBonus) {
    if (prize.getMatchCount() != matchCount) return false;
    if (prize.hasBonusVariant()) return prize.getIsBonus() == isBonus;
    return true;
  }
}
