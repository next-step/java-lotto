package lotto.domain;

import lotto.utility.RewardTable;

import java.util.*;

public class WinningStatistics {
  private final List<Integer> targetNumber;
  private final int bonusNumber;

  private int totalWinningPrice;

  public WinningStatistics(List<Integer> targetNumber, int bonusNumber) {
    this.bonusNumber = bonusNumber;
    this.targetNumber = targetNumber;
  }

  private Map<Integer, Integer> makeHashMap() {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=3; i<=6; i++) {
      map.put(i, 0);
    }

    return map;
  }

  public Map<Integer, Integer> lottoResult(List<Lotto> lottoBundle) {
    Map<Integer, Integer> map = makeHashMap();

    for (Lotto lotto : lottoBundle) {
      map.compute(lotto.matchLottoNumber(this.targetNumber), (key, value) -> value == null ? 1 : value + 1);
      calcWinningPrice(lotto.matchLottoNumber(this.targetNumber));
    }

    return map;
  }

  private void calcWinningPrice(int key) {
    if (key >= RewardTable.MINIMUM_MATCH_NUMBER) {
      this.totalWinningPrice += RewardTable.rewardTableInfo(key).amountOfReward();
    }
  }

  public double calcRoi(int totalWinningPrice, int investment) {
    double result = 1 + (totalWinningPrice - investment) / (double) investment;

    return result;
  }

  public int showTotalWinningPrice() {
    return this.totalWinningPrice;
  }

  public List<Integer> showTargetNumber() {
    return new ArrayList<>(this.targetNumber);
  }
}
