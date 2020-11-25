package lotto.views;

public class ReportForm {

  private final int numHit;
  private final int reward;
  private final boolean containsBonus;
  private final int numHitCount;

  public ReportForm(int numHit, int reward, boolean containsBonus, int numHitCount) {
    this.numHit = numHit;
    this.reward = reward;
    this.containsBonus = containsBonus;
    this.numHitCount = numHitCount;
  }

  public int getNumHit() {
    return numHit;
  }

  public int getReward() {
    return reward;
  }

  public boolean containsBonus() {
    return containsBonus;
  }

  public int getNumHitCount() {
    return numHitCount;
  }
}
