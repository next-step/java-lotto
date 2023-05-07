package lotto.domain;

import lotto.utility.RewardTable;

import java.util.*;

public class WinningStatistics {
  public final List<Integer> targetNumber;

  private int totalWinningPrice;

  public WinningStatistics(List<Integer> targetNumber) {
    this.targetNumber = targetNumber;
  }

  public Map<Integer, Integer> lottoResult(List<Lotto> lottoBundle) {
    Map<Integer, Integer> map = new HashMap<>();

    for (Lotto lotto : lottoBundle) {
      map.compute(lotto.matchLottoNumber(this.targetNumber),  (key, value) -> value == null ? 1 : value + 1);
      calcWinningPrice(lotto.matchLottoNumber(this.targetNumber));
    }

    // 작동이 안되는 이유가 무엇인가요?
    // 위와 뭐가 다른 지 모르겠습니다...
//        lottoBundle.stream()
//                .mapToInt(lotto -> lotto.matchLottoNumber(this.targetNumber))
//                .map(key -> map.put(key, map.getOrDefault(key, 0) + 1));

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
