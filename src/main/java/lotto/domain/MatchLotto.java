package lotto.domain;

import java.util.Arrays;

public enum MatchLotto {
  NONE(Integer.MIN_VALUE, 0),
  FOURTH(3, 5000),
  THIRD(4, 50000),
  SECOND(5, 1500000),
  FIRST(6, 2000000000);

  private int matchCount;
  private Money winnerMoney;

  MatchLotto(int matchCount, int winnerMoney) {
    this.matchCount = matchCount;
    this.winnerMoney = new Money(winnerMoney);
  }

  public int getWinnerMoney() {
    return winnerMoney.toInt();
  }

  public static MatchLotto findPrize(String winnerRank) {
    return Arrays.stream(MatchLotto.values())
        .filter(matches -> matches.name().equals(winnerRank))
        .findAny()
        .orElseThrow(IllegalArgumentException::new);
  }

  public static MatchLotto valueOf(int matchCount) {
    return Arrays.stream(MatchLotto.values())
        .filter(matches -> matches.matchCount == matchCount)
        .findAny()
        .orElse(MatchLotto.NONE);
  }

  public static boolean isNone(MatchLotto matchLotto) {
    return matchLotto == MatchLotto.NONE;
  }
}
