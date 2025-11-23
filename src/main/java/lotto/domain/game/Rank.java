package lotto.domain.game;

public enum Rank {

  FIRST(2_000_000_000, 6),
  SECOND(1_500_000, 5),
  THIRD(50_000, 4),
  FOURTH(5000, 3),
  NONE(0, -1);

  private int prize;
  private int matched;

  Rank(int prize, int matched) {
    this.prize = prize;
    this.matched = matched;
  }

  public static Rank valueOf(int matched) {
    for (Rank rank : values()) {
      if (rank.matched == matched) {
        return rank;
      }
    }
    return NONE;
  }

  public int getPrize() {
    return this.prize;
  }

  @Override
  public String toString() {
    return this.matched + "개 일치 (" + this.prize + "원)";
  }
}