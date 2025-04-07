package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
  FIRST(Arrays.asList(6), 2_000_000_000, false),
  SECOND(Arrays.asList(5), 30_000_000, true),
  THIRD(Arrays.asList(5), 1_500_000, false),
  FOURTH(Arrays.asList(4), 50_000, false),
  FIFTH(Arrays.asList(3), 5_000, false),
  MISS(Arrays.asList(0, 1, 2), 0, false);

  private final List<Integer> matchCounts;
  private final int winningMoney;
  private final boolean matchBonus;

  Rank(List<Integer> matchCounts, int winningMoney, boolean matchBonus) {
    this.matchCounts = matchCounts;
    this.winningMoney = winningMoney;
    this.matchBonus = matchBonus;
  }

  public List<Integer> getMatchCounts() {
    return matchCounts;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public boolean isMatchBonus() {
    return matchBonus;
  }

  public int getCountOfMatch() {
    return matchCounts.stream().mapToInt(Integer::intValue).max().orElse(0);
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    if (countOfMatch > 6) {
      throw new IllegalArgumentException("일치하는 번호는 최대 6개까지만 가능합니다.");
    }

    if (countOfMatch == 5) {
      return matchBonus ? SECOND : THIRD;
    }

    return Arrays.stream(values())
        .filter(rank -> rank.matchCounts.contains(countOfMatch))
        .findFirst()
        .orElse(MISS);
  }
}
