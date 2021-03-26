package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {
  private final Map<Long, Integer> rewardBoard;
  private double earningRate;

  public LottoResultDto() {
    rewardBoard = new HashMap<>();
  }

  public void putRewardRecord(long countMatches) {
    if (rewardBoard.containsKey(countMatches)) {
      rewardBoard.put(countMatches, rewardBoard.get(countMatches) + 1);
      return;
    }
    rewardBoard.put(countMatches, 1);
  }

  public double getEarningRate() {
    return earningRate;
  }

  public void setEarningRate(double earningRate) {
    this.earningRate = earningRate;
  }
}
