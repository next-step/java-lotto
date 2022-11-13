package nextstep.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoSummary {

  private final int gamePrice;
  private final List<LottoResult> results;
  private final Map<LottoResult, Long> countMap;

  public LottoSummary(final int gamePrice, final List<LottoResult> results) {
    this.gamePrice = gamePrice;
    this.results = results;
    this.countMap = results.stream()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public List<LottoWinCount> winResults() {
    return countMap.entrySet().stream()
      .filter(entry -> entry.getKey() != LottoResult.LOSE)
      .map(entry -> new LottoWinCount(entry.getKey(), entry.getValue()))
      .collect(Collectors.toList());
  }

  public BigDecimal rateOfReturn() {
    final int totalGameCount = results.size();
    final BigDecimal totalPrice =
      results.stream()
        .map(result -> new BigDecimal(result.price()))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return totalPrice.divide(new BigDecimal(gamePrice * totalGameCount), 2, RoundingMode.HALF_UP);
  }
}
