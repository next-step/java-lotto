package lotto;

import java.util.Arrays;

public enum Rank {

  FIRST(6, 2000000000),
  SECOND(5, 30000000,true),
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIFTH(3, 5000),
  MISS(0, 0);

  private int boundaryCount;
  private int prize;
  private boolean bonusMatch;

  Rank(int boundaryCount, int prize) {
    this(boundaryCount,prize,false);
  }

  Rank(int boundaryCount, int prize, boolean bonusMatch) {
    this.boundaryCount = boundaryCount;
    this.prize = prize;
    this.bonusMatch = bonusMatch;
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.boundaryCount== countOfMatch)
        .filter(rank -> rank.bonusMatch== matchBonus)
        .findFirst()
        .orElse(Rank.MISS);
  }

  public int getBoundaryCount() {
    return boundaryCount;
  }

  public int getPrize() {
    return prize;
  }

  public boolean isBonusMatch() {
    return bonusMatch;
  }

}
