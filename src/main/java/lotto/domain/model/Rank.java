package lotto.domain.model;

import static lotto.domain.LottoGame.LOTTO_NO_COUNT;
import static lotto.domain.model.Trilean.FALSE;
import static lotto.domain.model.Trilean.IRRELAVANT;
import static lotto.domain.model.Trilean.TRUE;

import java.util.Arrays;

public enum Rank {
  FAILURE(0, IRRELAVANT, 0),
  FIFTH(3, IRRELAVANT, 5_000),
  FOURTH(4, IRRELAVANT, 50_000),
  THIRD(5, FALSE, 1_500_000),
  SECOND(5, TRUE, 30_000_000),
  FIRST(6, IRRELAVANT, 2_000_000_000);

  private int matchCount;
  private Trilean shouldMatchBonus;
  private int winningMoney;

  Rank(int matchCount, Trilean shouldMatchBonus, int winningMoney) {
    this.matchCount = matchCount;
    this.shouldMatchBonus = shouldMatchBonus;
    this.winningMoney = winningMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public Trilean getShouldMatchBonus() {
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
    return this.matchCount == matchCount && this.shouldMatchBonus.matches(bonusMatched);
  }
}
