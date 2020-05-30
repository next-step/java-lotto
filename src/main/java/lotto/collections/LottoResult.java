package lotto.collections;

import java.util.Map;
import lotto.util.LottoProfitCalculator;

public class LottoResult {

  private final Map<Integer, Integer> lottoStatistics;

  public LottoResult(Map<Integer, Integer> lottoStatistics) {
    this.lottoStatistics = lottoStatistics;
  }

  public double getLottoProfitRate(final int lottoTicketSize) {
    double totalProfit = RewardType.calculateProfit(lottoStatistics);
    return new LottoProfitCalculator(totalProfit, lottoTicketSize).getConvertProfit();
  }

  public Map<Integer, Integer> getLottoStatistics() {
    return lottoStatistics;
  }
}
