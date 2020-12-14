package step2.domain.result;

import step2.enums.LottoWinningEnum;
import step2.domain.UserLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
  private final Map<LottoWinningEnum, Integer> matchResultMap;
  private final double earningRate;

  public LottoResult(List<UserLotto> userLottoList, int lottoPrice) {
    int sum = 0;
    Map<LottoWinningEnum, Integer> winningMatchResults = new HashMap<>();
    for (LottoWinningEnum lottoEnum : LottoWinningEnum.values()) {
      long lottoMatchSize = getMatchLottoSize(userLottoList, lottoEnum.getMatchCount());
      sum += lottoMatchSize > 0 ? getTotalReward(lottoEnum.getReward(), lottoMatchSize) : 0;
      winningMatchResults.put(lottoEnum, (int) lottoMatchSize);
    }
    this.matchResultMap = winningMatchResults;
    this.earningRate = sum / (double) lottoPrice;
  }

  private long getTotalReward(int reward, long lottoMatchSize) {
    return reward * lottoMatchSize;
  }

  private long getMatchLottoSize(List<UserLotto> userLottoList, int matchCount) {
    return userLottoList.stream()
        .filter(lotto -> lotto.getMatchCount() == matchCount)
        .count();
  }

  public Map<LottoWinningEnum, Integer> getMatchResultMap() {
    return this.matchResultMap;
  }

  public double getEarningRate() {
    return this.earningRate;
  }

}
