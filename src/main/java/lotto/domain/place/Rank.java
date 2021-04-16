package lotto.domain.place;

import java.util.Arrays;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000, true),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private final int countOfMatch;
  private final int winningMoney;
  private final boolean matchBonus;

  Rank(int countOfMatch, int winningMoney) {
    this(countOfMatch, winningMoney, false);
  }

  Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
    this.matchBonus = matchBonus;
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    return Arrays.stream(Rank.values())
            .filter(rank -> rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("입력 값이 맞지 않습니다."));
  }

  int getCountOfMatch() {
    return countOfMatch;
  }

  int getWinningMoney() {
    return winningMoney;
  }
}
