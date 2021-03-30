package step2.domain;

import step2.domain.number.Count;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
  private final Map<Count, Count> results;
  private final Map<Count, Cash> outputInfo;
  private Double yield;

  private static final int MATCHING_THREE = 5000;
  private static final int MATCHING_FOUR = 50000;
  private static final int MATCHING_FIVE = 1500000;
  private static final int MATCHING_SIX = 2000000000;

  private static final int ADDING_MIN_COUNT = 1;
  private static final int STANDARD_SIZE = 6;
  private static final int ROUNDING_SIZE = 2;

  public LottoResult() {
    results = new HashMap<>();
    for(int i=1; i<=STANDARD_SIZE; i++){
      results.put(new Count(i), new Count());
    }

    yield = 0D;
    outputInfo = new HashMap<>();
    putOutputInfo();
  }

  private void putOutputInfo() {
    outputInfo.put(new Count(3), new Cash(MATCHING_THREE));
    outputInfo.put(new Count(4), new Cash(MATCHING_FOUR));
    outputInfo.put(new Count(5), new Cash(MATCHING_FIVE));
    outputInfo.put(new Count(6), new Cash(MATCHING_SIX));
  }

  public void add(Count matchingResult) {
    Count addingCount = results.getOrDefault(matchingResult, new Count());
    addingCount = addingCount.addCount(new Count(ADDING_MIN_COUNT));
    results.put(matchingResult, addingCount);
  }

  @Override
  public String toString() {
    return "LottoResult{" +
      "results=" + results +
      '}';
  }

  public String toStringSpecificResult(Count target) {
    Count result = results.getOrDefault(target, new Count(0));
    return result.toString();
  }

  public void calcYield(Cash sellerMoney) {
    Cash revenue = calcTotalRevenue();
    yield = revenue.divide(sellerMoney);
  }

  private Cash calcTotalRevenue() {
    Cash result = new Cash(0);

    for (Count number : outputInfo.keySet()) {
      Count count = results.getOrDefault(number, new Count());
      result = result.add(outputInfo.get(number).multiply(count));
    }

    return result;
  }

  public String toStringYield() {
    BigDecimal bigDecimal = new BigDecimal(yield).setScale(ROUNDING_SIZE, RoundingMode.HALF_UP);
    double roundedYield = bigDecimal.doubleValue();
    return Double.toString(roundedYield);
  }
}