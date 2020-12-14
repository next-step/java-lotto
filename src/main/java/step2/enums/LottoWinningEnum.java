package step2.enums;

public enum LottoWinningEnum {
  THREE_MATCH(3, 5000, "3개 일치"),
  FOUR_MATCH(4, 50000, "4개 일치"),
  FIVE_MATCH(5, 1500000, "5개 일치"),
  FIVE_BONUS_MATCH(5, 30000000, "5개 일치, 보너스 볼 일치"),
  SIX_MATCH(6, 2000000000, "6개 일치");

  private final int matchCount;
  private final int reward;
  private final String displayName;

  LottoWinningEnum(int matchCount, int reward, String displayName) {
    this.matchCount = matchCount;
    this.reward = reward;
    this.displayName = displayName;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getReward() {
    return this.reward;
  }

  public String getDisplayName() {
    return displayName;
  }
}
