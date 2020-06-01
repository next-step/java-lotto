package lotto.model;

public enum PrizeTier {
  MATCH_SIX(2000000000, 6),
  MATCH_FIVE(1500000, 5),
  MATCH_FOUR(50000, 4),
  MATCH_THREE(5000, 3),
  MATCH_ZERO(0, 0);

  private final int prize;
  private final int matchCnt;

  PrizeTier(int prize, int matchCnt) {
    this.prize = prize;
    this.matchCnt = matchCnt;
  }

  public int getPrize() {
    return prize;
  }

  public int getMatchCnt() {
    return matchCnt;
  }
}
