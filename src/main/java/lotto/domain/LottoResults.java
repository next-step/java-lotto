package lotto.domain;

import lotto.constants.PrizeGrade;
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
    return resolveGroupByPrizeGrade(prizeGrades.stream()
        .filter(prizeGrade -> prizeGrade != PrizeGrade.FAIL)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(confirmResult -> INCREASE))));
  }

  private Map<PrizeGrade, Integer> resolveGroupByPrizeGrade(Map<PrizeGrade, Integer> groupedByPrizeGrade) {
    Arrays.stream(PrizeGrade.values())
        .filter(prizeGrade -> !groupedByPrizeGrade.containsKey(prizeGrade))
        .filter(prizeGrade -> prizeGrade != PrizeGrade.FAIL)
        .forEach(prizeGrade -> groupedByPrizeGrade.put(prizeGrade, 0));
    return groupedByPrizeGrade;
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
