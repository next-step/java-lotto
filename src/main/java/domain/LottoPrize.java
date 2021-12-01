package domain;

import java.util.Arrays;

public enum LottoPrize {
  NONE(0, 0),
  FIFTH(3, 5_000),
  FOURTH(4, 50_000),
  THIRD(5, 1_500_000),
  SECOND(5, 30_000_000),
  FIRST(6, 2_000_000_000);

  public final int matchCount;
  public final int prize;

  LottoPrize(int matchCount, int prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public static LottoPrize find(int matchCount, boolean containsBonus) {
    if (isBonusMatched(matchCount, containsBonus)) {
      return SECOND;
    }
    return Arrays.stream(values())
            .filter(lottoResult -> lottoResult.matchCount == matchCount)
            .findAny()
            .orElse(NONE);
  }

  private static boolean isBonusMatched(int matchCount, boolean containsBonus) {
    return matchCount == SECOND.matchCount && containsBonus;
  }

}
