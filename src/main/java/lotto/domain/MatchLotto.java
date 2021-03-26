package lotto.domain;

import java.util.Arrays;

public enum MatchLotto {
  NONE(Integer.MIN_VALUE, 0, "NONE"),
  FOURTH(3, 5000, "FOURTH"),
  THIRD(4, 50000, "THIRD"),
  SECOND(5, 1500000, "SECOND"),
  FIRST(6, 2000000000, "FIRST");

  private int matchCount;
  private Money winnerMoney;
  private String winnerRank;

  MatchLotto(int matchCount, int winnerMoney, String winnerRank) {
    this.matchCount = matchCount;
    this.winnerMoney = new Money(winnerMoney);
    this.winnerRank = winnerRank;
  }

  public String getWinnerRank() {
    return winnerRank;
  }

  public int getWinnerMoney() {
    return winnerMoney.toInt();
  }

  public static MatchLotto findPrize(String winnerRank) {
    return Arrays.stream(MatchLotto.values())
        .filter(matches -> matches.winnerRank.equals(winnerRank))
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
