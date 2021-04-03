package step3.domain.result;

import step3.domain.Cash;
import step3.domain.number.Count;
import step3.domain.number.LottoMatchingNumber;

import java.util.HashMap;
import java.util.Map;

public class LottoRevenueResult {
  private static final int MATCHING_THREE = 5_000;
  private static final int MATCHING_FOUR = 50_000;
  private static final int MATCHING_FIVE = 1_500_000;
  private static final int MATCHING_SIX = 2_000_000_000;

  private final Map<LottoMatchingNumber, Cash> outputInfo;

  public LottoRevenueResult() {
    outputInfo = new HashMap<>();
    putOutputInfo();
  }

  private void putOutputInfo() {
    outputInfo.put(new LottoMatchingNumber(3), new Cash(MATCHING_THREE));
    outputInfo.put(new LottoMatchingNumber(4), new Cash(MATCHING_FOUR));
    outputInfo.put(new LottoMatchingNumber(5), new Cash(MATCHING_FIVE));
    outputInfo.put(new LottoMatchingNumber(6), new Cash(MATCHING_SIX));
  }

  public Cash calcTotalRevenue(LottoMatchingResult results) {
    Cash result = new Cash(0);

    for (LottoMatchingNumber number : outputInfo.keySet()) {
      Count count = results.sendSpecificCount(number);
      result = result.add(outputInfo.get(number).multiply(count));
    }

    return result;
  }
}