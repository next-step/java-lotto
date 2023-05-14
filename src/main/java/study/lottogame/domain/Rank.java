package study.lottogame.domain;

import java.util.Arrays;

public enum Rank {
  MISS(0, 0) {
    @Override
    public boolean matches(int countOfMatch, boolean matchBonus) {
      return countOfMatch == 0;
    }
  },
  FIFTH(3, 5_000) {
    @Override
    public boolean matches(int countOfMatch, boolean matchBonus) {
      return countOfMatch == 3;
    }
  },
  FOURTH(4, 50_000) {
    @Override
    public boolean matches(int countOfMatch, boolean matchBonus) {
      return countOfMatch == 4;
    }
  },
  THIRD(5, 1_500_000) {
    @Override
    public boolean matches(int countOfMatch, boolean matchBonus) {
      return countOfMatch == 5 && !matchBonus;
    }
  },
  SECOND(5, 30_000_000) {
    @Override
    public boolean matches(int countOfMatch, boolean matchBonus) {
      return countOfMatch == 5 && matchBonus;
    }
  },
  FIRST(6, 2_000_000_000) {
    @Override
    public boolean matches(int countOfMatch, boolean matchBonus) {
      return countOfMatch == 6;
    }
  };

  private int countOfMatch;
  private int winningMoney;

  private Rank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public abstract boolean matches(int countOfMatch, boolean matchBonus);

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.matches(countOfMatch, matchBonus))
        .findFirst()
        .orElse(Rank.MISS);
  }
}
