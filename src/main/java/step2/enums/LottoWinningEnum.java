package step2.enums;

public enum LottoWinningEnum {
  THREE_MATCH(3, 5000),
  FOUR_MATCH(4, 50000),
  FIVE_MATCH(5, 1500000),
  SIX_MATCH(6, 2000000000);

  private final int matchCount;
  private final int reward;

  LottoWinningEnum(int matchCount, int reward) {
    this.matchCount = matchCount;
    this.reward = reward;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getReward() {
    return this.reward;
  }

}
