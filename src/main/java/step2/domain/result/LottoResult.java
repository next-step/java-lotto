package step2.domain.result;

import step2.enums.LottoWinningEnum;
import step2.domain.UserLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
  private final List<WinningMatchResult> matchResults;
  private final double earningRate;

  public LottoResult(List<UserLotto> userLottoList, int lottoPrice) {
    int sum = 0;
    List<WinningMatchResult> winningMatchResults = new ArrayList<>();
    for (LottoWinningEnum lottoEnum : LottoWinningEnum.values()) {
      long lottoMatchSize = getMatchLottoSize(userLottoList, lottoEnum.getMatchCount());
      sum += lottoMatchSize > 0 ? getTotalReward(lottoEnum.getReward(), lottoMatchSize) : 0;
      winningMatchResults.add(new WinningMatchResult(lottoEnum, lottoMatchSize));
    }
    this.matchResults = winningMatchResults;
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

  public List<WinningMatchResult> getMatchResults() {
    return this.matchResults;
  }

  public double getEarningRate() {
    return this.earningRate;
  }

}
