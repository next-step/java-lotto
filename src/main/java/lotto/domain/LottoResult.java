package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {

  FIRST(Arrays.asList(6), 2000000000),
  SECOND(Arrays.asList(5), 1500000),
  THIRD(Arrays.asList(4), 50000),
  FOURTH(Arrays.asList(3), 5000),
  LOSE(Arrays.asList(0, 1, 2), 0);

  private List<Integer> containsCount;
  private int rewardPrice;

  LottoResult(List<Integer> containsCount, int rewardPrice) {
    this.containsCount = containsCount;
    this.rewardPrice = rewardPrice;
  }

  public static LottoResult findResult(int containsCount) {
    LottoResult result = null;
    for (LottoResult value : LottoResult.values()) {
      result = checkValue(containsCount, result, value);
    }
    return result;
  }

  private static LottoResult checkValue(int containsCount, LottoResult result, LottoResult value) {
    if (value.containsCount.contains(containsCount)) {
      result = value;
    }
    return result;
  }

  public int getRewardPrice() {
    return rewardPrice;
  }

  public int getRewardPrice(int count) {
    return rewardPrice * count;
  }

  public List<Integer> getContainsCount() {
    return containsCount;
  }
}
