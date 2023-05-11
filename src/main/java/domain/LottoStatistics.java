package domain;

import util.LottoManager;
import util.LottoSeller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {
  private final List<LottoResult> lottoResults;

  public LottoStatistics(final List<LottoResult> lottoResults) {
    this.lottoResults = lottoResults;
  }

  public float getProfitRate() {
    return calculateProfitRate(LottoSeller.LOTTO_PRICE * lottoResults.size(),
            sumOfLottoResult(lottoResults));
  }

  public Map<LottoResult, Long> groupAndCounting() {
    return lottoResults.stream()
        .filter(lottoResultType -> lottoResultType != LottoResult.NONE)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static int sumOfLottoResult(Collection<LottoResult> lottoResults) {
    return lottoResults.stream()
            .mapToInt(LottoResult::winningMoney)
            .sum();
  }

  public static float calculateProfitRate(int purchaseAmount, int winningMoney) {
    return (float) winningMoney / purchaseAmount;
  }
}
