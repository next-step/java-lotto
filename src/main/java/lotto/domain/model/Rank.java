package lotto.domain.model;

import static lotto.domain.LottoGame.LOTTO_NO_COUNT;

import java.util.Arrays;

public enum Rank {
  FAILURE(0, null, 0),
  FIFTH(3, null, 5_000),
  FOURTH(4, null, 50_000),
  THIRD(5, false, 1_500_000),
  SECOND(5, true, 30_000_000),
  FIRST(6, null, 2_000_000_000);

  private int matchCount;
  private Boolean shouldMatchBonus;
  private int winningMoney;

  Rank(int matchCount, Boolean shouldMatchBonus, int winningMoney) {
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
    return this.matchCount == matchCount &&
        (this.shouldMatchBonus == null || this.shouldMatchBonus.equals(bonusMatched));
  }
}
