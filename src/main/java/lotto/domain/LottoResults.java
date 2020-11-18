package lotto.domain;

import lotto.constants.RateOfReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.constants.Message.RATE_OF_RETURN_FORMAT;

public class LottoResults {

  private final Map<PrizeGrade, Integer> groupedByPrizeGrade;

  private static final int ZERO = 0;
  private static final int INCREASE = 1;

  public LottoResults(List<PrizeGrade> prizeGrades) {
    this.groupedByPrizeGrade = groupByPrizeGrade(prizeGrades);
  }

  public long prizeMoneySum() {
    return groupedByPrizeGrade.keySet().stream()
        .filter(key -> groupedByPrizeGrade.get(key) != 0)
        .mapToLong(PrizeGrade::getPrizeMoney)
        .reduce(ZERO, Long::sum);
  }

  public Map<PrizeGrade, Integer> getGroupedByPrizeGrade() {
    return groupedByPrizeGrade;
  }

  public String computeRateOfReturn(PurchaseAction purchaseAction) {
    long prizeMoneySum = this.prizeMoneySum();
    double rateOfReturn = (double) prizeMoneySum / (double) purchaseAction.getPurchasePrice();
    return String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage());
  }

  private Map<PrizeGrade, Integer> groupByPrizeGrade(List<PrizeGrade> prizeGrades) {
    return Arrays.stream(PrizeGrade.values())
        .filter(prizeGrade -> prizeGrade != PrizeGrade.FAIL)
        .collect(Collectors.toMap(Function.identity(),
            prizeGrade -> resolveGroupByPrizeGrade(prizeGrades, prizeGrade)));
  }

  private Integer resolveGroupByPrizeGrade(List<PrizeGrade> prizeGrades, PrizeGrade prizeGrade) {
    return prizeGrades.stream()
        .filter(result -> result == prizeGrade)
        .map(result -> INCREASE)
        .reduce(ZERO, Integer::sum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoResults that = (LottoResults) o;
    return groupedByPrizeGrade.equals(that.groupedByPrizeGrade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupedByPrizeGrade);
  }
}
