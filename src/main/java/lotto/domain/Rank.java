package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private final int countOfMatch;
  private final int winningMoney;

  Rank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    for (Rank rank : Rank.getListFindBy(countOfMatch)) {
      if (rank.isBonusBallCheckCountOfMatch()) {
        return getBonusBallMatchedRank(matchBonus);
      }
      return rank;
    }
    throw new IllegalArgumentException("입력 값이 맞지 않습니다.");
  }

  private static List<Rank> getListFindBy(final int countOfMatch) {
    return Arrays.stream(Rank.values())
            .filter(rank -> countOfMatch == rank.countOfMatch)
            .collect(Collectors.toList());
  }

  private static Rank getBonusBallMatchedRank(boolean matchBonus) {
    if (matchBonus) {
      return SECOND;
    }

    return THIRD;
  }

  private boolean isBonusBallCheckCountOfMatch() {
    final int bonusCheckCountOfMatch = 5;
    return this.countOfMatch == bonusCheckCountOfMatch;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }


}
