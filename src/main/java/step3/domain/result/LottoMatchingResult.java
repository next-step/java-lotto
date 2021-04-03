package step3.domain.result;

import step3.domain.number.Count;
import step3.domain.number.LottoMatchingNumber;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchingResult {
  private static final int STANDARD_SIZE = 6;
  private static final int ADDING_MIN_COUNT = 1;
  private static final int ZERO = 0;

  private final Map<LottoMatchingNumber, Count> results;

  public LottoMatchingResult() {
    results = new HashMap<>();
    for (int i = 1; i <= STANDARD_SIZE; i++) {
      results.put(new LottoMatchingNumber(i), new Count());
    }
  }

  public void add(LottoMatchingNumber matchingResult) {
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

  public String toStringSpecificResult(LottoMatchingNumber target) {
    Count result = results.getOrDefault(target, new Count(ZERO));
    return result.toString();
  }

  public Count sendSpecificCount(LottoMatchingNumber number) {
    return results.getOrDefault(number, new Count());
  }
}
