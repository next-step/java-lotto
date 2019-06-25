package lotto;

import java.util.List;

public class Rewards {

  private List<Reward> rewards;

  public Rewards(List<Reward> rewards) {
    this.rewards = rewards;
  }

  public double getIncome() {
    return rewards.stream().mapToDouble(Reward::getRewardMoney).sum();
  }

  public List<Reward> getRewards() {
    return rewards;
  }
}
