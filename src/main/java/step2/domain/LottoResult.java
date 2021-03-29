package step2.domain;

import step2.domain.number.Number;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
  private final Map<Number, Number> results;
  private final Map<Number, Cash> outputInfo;
  private Double yield;

  private static final int MATCHING_THREE = 5000;
  private static final int MATCHING_FOUR = 50000;
  private static final int MATCHING_FIVE = 1500000;
  private static final int MATCHING_SIX = 2000000000;
  private static final String DIGIT = "개";

  public LottoResult() {
    results = new HashMap<>();
    yield = 0D;
    outputInfo = new HashMap<>();
    putOutputInfo();
  }

  private void putOutputInfo() {
    outputInfo.put(new Number(3), new Cash(MATCHING_THREE));
    outputInfo.put(new Number(4), new Cash(MATCHING_FOUR));
    outputInfo.put(new Number(5), new Cash(MATCHING_FIVE));
    outputInfo.put(new Number(6), new Cash(MATCHING_SIX));
  }

  public void add(Number matchingResult) {
    Number sample = results.getOrDefault(matchingResult, new Number(0));
    results.put(matchingResult, sample);
  }

  @Override
  public String toString() {
    return "LottoResult{" +
      "results=" + results +
      '}';
  }

  public String toStringSpecificResult(Number target) {
    Number result = results.getOrDefault(target, new Number(0));
    return result.toString() + DIGIT;
  }

  public void calcYield(Cash sellerMoney) {
    Cash revenue = calcTotalRevenue();
    yield = revenue.divide(sellerMoney);
  }

  private Cash calcTotalRevenue() {
    Cash result = new Cash(0);

    for (Number number : results.keySet()) {
      Number count = results.getOrDefault(number, new Number(0));
      result = result.add(outputInfo.get(number).multiply(count));
    }
//  results.forEach((number, count)->result = result.add(outputInfo.get(number).multiply(count)));

    return result;
  }

  public String toStringYield() {
    return yield.toString();
  }
}
