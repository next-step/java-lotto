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

  public Map<Integer, Integer> lottoResult(List<Lotto> lottoBundle) {
    Map<Integer, Integer> map = new HashMap<>();

    int matchNumberKey = 0;

    for (Lotto lotto : lottoBundle) {
      matchNumberKey = RewardTable.bonusRankSeparator(lotto.isMatchBonusNumber(bonusNumber), lotto.matchLottoNumber(this.targetNumber));
      map.compute(matchNumberKey, (key, value) -> value == null ? 1 : value + 1);

      calcWinningPrice(matchNumberKey);
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
