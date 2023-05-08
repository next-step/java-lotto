package domain;

import util.LottoManager;
import util.LottoSeller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {
  private final List<LottoResult> lottoResults;

  public LottoStatistics(final List<LottoResult> lottoResults) {
    this.lottoResults = lottoResults;
  }

  public String serializeStatistics() {
    StringBuilder builder = new StringBuilder();
    builder.append("당첨 통계\n");
    builder.append("---------\n");

    final Map<LottoResult, Long> lottoResultMap = groupAndCounting();

    LottoResult.findByWinning()
        .forEach(e -> builder.append(serializeResult(e, Optional.ofNullable(lottoResultMap.get(e)).orElse(0L))));

    builder.append(String.format("총 수익률은 %.2f입니다.\n",
        LottoManager.calculateProfitRate(LottoSeller.LOTTO_PRICE * lottoResults.size(),
            LottoManager.sumOfLottoResult(lottoResults))));

    return builder.toString();
  }

  public Map<LottoResult, Long> groupAndCounting() {
    return lottoResults.stream()
        .filter(lottoResultType -> lottoResultType != LottoResult.NONE)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  private String serializeResult(LottoResult resultType, long count) {
    if (resultType == LottoResult.SECOND) {
      return String.format(String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개\n", resultType.matchCount(), resultType.winningMoney(), count));
    }

    return String.format("%d개 일치 (%d원) - %d개\n", resultType.matchCount(), resultType.winningMoney(), count);
  }
}
