package lotto.domain;

import java.util.Arrays;

public enum Rank {
  MISS(0, 0, "0개 일치"),
  FIFTH(3, 5_000, "3개 일치"),
  FOURTH(4, 50_000, "4개 일치"),
  THIRD(5, 1_500_000, "5개 일치"),
  SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
  FIRST(6, 2_000_000_000, "6개 일치");

  private final static Long BONUS_COUNT_NUMBER = 5L;

  private int countOfMatch;
  private int winningMoney;
  private String resultString;

  private Rank(int countOfMatch, int winningMoney, String resultString) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
    this.resultString = resultString;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  private static Rank valueOf(long countOfMatch) {
    return Arrays.stream(Rank.values())
        .filter(rank -> countOfMatch == rank.countOfMatch)
        .findAny()
        .orElse(Rank.MISS);
  }

  public static Rank valueOf(long countOfMatch, boolean matchBonus) {
    if (matchBonus && countOfMatch == BONUS_COUNT_NUMBER) {
      return SECOND;
    }
    return valueOf(countOfMatch);
  }

  public String printString() {
    return resultString;
  }

  public long getMoney(long winCount) {
    return winningMoney * winCount;
  }
}
