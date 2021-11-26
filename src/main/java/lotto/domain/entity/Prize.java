package lotto.domain.entity;

public enum Prize {

  FOURTH(3, 5000),
  THIRD(4, 50000),
  SECOND(5, 1500000),
  FIRST(6, 2000000000);

  private final int matchedCount;
  private final int reward;

  Prize(int matchedCount, int reward) {
    this.matchedCount = matchedCount;
    this.reward = reward;
  }

  public int getMatchedCount() {
    return matchedCount;
  }

  public int getReward() {
    return reward;
  }
}
