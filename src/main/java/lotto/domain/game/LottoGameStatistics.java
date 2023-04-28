package lotto.domain.game;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.round.LottoRoundResult;

public class LottoGameStatistics {
  private final Map<LottoWinType, List<LottoRoundResult>> winTypeMap;
  private final BigDecimal totalRateOfReturn;

  public LottoGameStatistics (int purchasePrice, List<LottoRoundResult> roundStatistics) {
    this.winTypeMap = initWinTypeMap(roundStatistics);
    this.totalRateOfReturn = calculateTotalRateOfReturn(purchasePrice, roundStatistics);
  }

  public Map<LottoWinType, List<LottoRoundResult>> getWinTypeMap() {
    return winTypeMap;
  }

  public BigDecimal getTotalRateOfReturn () {
    return totalRateOfReturn;
  }

  private BigDecimal calculateTotalRateOfReturn(int purchasePrice, List<LottoRoundResult> roundStatistics) {
    BigDecimal totalEarn = BigDecimal.valueOf(getTotalEarn(roundStatistics));
    BigDecimal price = BigDecimal.valueOf(purchasePrice);

    return totalEarn.divide(price, 2, RoundingMode.FLOOR);
  }

  private int getTotalEarn (List<LottoRoundResult> roundStatistics) {
    return roundStatistics.stream()
        .mapToInt(LottoRoundResult::getWinningPrize)
        .sum();
  }

  private Map<LottoWinType, List<LottoRoundResult>> initWinTypeMap(List<LottoRoundResult> roundStatistics) {
    return roundStatistics.stream()
        .filter(statistic -> statistic.getWinType() != null)
        .collect(Collectors.groupingBy(LottoRoundResult::getWinType));
  }
}
