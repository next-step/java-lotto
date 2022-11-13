package nextstep.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoSummary {

  private final int gamePrice;
  private final List<LottoResult> results;

  public LottoSummary(final int gamePrice, final List<LottoResult> results) {
    this.gamePrice = gamePrice;
    this.results = results;
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
