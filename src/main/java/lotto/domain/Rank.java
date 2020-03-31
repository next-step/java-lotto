package lotto.domain;

import static lotto.domain.LottoGame.LOTTO_NO_COUNT;

import java.util.Arrays;

public enum Rank {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  FAILURE(0, false, 0);

  private int matchCount;
  private boolean shouldMatchBonus;
  private int winningMoney;

  Rank(int matchCount, boolean shouldMatchBonus, int winningMoney) {
    this.matchCount = matchCount;
    this.shouldMatchBonus = shouldMatchBonus;
    this.winningMoney = winningMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean getShouldMatchBonus() {
    return shouldMatchBonus;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public static Rank valueOf(int matchCount, boolean bonusMatched) {
    throwIfInvalid(matchCount);

    return Arrays.stream(values())
        .filter(rank -> rank.matchRank(matchCount, bonusMatched))
        .findFirst()
        .orElse(FAILURE);
  }

  private static void throwIfInvalid(int matchCount) {
    if (matchCount < 0 || matchCount > LOTTO_NO_COUNT) {
      throw new IllegalArgumentException("matchCount should be between 1 and 6.");
    }
  }

  private boolean matchRank(int matchCount, boolean bonusMatched) {
    return this.matchCount == matchCount && (!this.shouldMatchBonus || bonusMatched);
  }
}
