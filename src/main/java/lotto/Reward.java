package lotto;

public class Reward {

  private int matchedCount;
  private PrizeInformation prizeInformation;

  public Reward(PrizeInformation prizeInfo, int matchedCount) {
    this.matchedCount = matchedCount;
    this.prizeInformation = prizeInfo;
  }

  public int getBoundaryCount() {
    return prizeInformation.getBoundaryCount();
  }

  public int getPrize() {
    return prizeInformation.getPrize();
  }

  public int getMatchedCount() {
    return matchedCount;
  }

  public int getRewardMoney() {
    return matchedCount * getPrize();
  }


}
