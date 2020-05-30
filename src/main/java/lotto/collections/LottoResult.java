package lotto.collections;

import java.util.Map;

public class LottoResult {

  private final Map<Integer, Integer> lottoStatistics;

  public LottoResult(Map<Integer, Integer> lottoStatistics) {
    this.lottoStatistics = lottoStatistics;
  }

  public Map<Integer, Integer> getLottoStatistics() {
    return lottoStatistics;
  }
}
