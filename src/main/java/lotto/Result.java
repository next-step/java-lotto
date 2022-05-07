package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Result {

  private static final String MESSAGE_FOR_MATCHED_LOTTO_COUNT = "- %s";

  private final Map<LottoPrize, Integer> result;

  Result() {
    this.result = new HashMap<>();
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      result.put(lottoPrize, 0);
    }
  }

  Result(Map<LottoPrize, Integer> result) {
    this.result = result;
  }

  public void add(LottoPrize lottoPrize) {
    result.put(lottoPrize, result.get(lottoPrize) + 1);
  }

  public int getMatchedLottoCount(LottoPrize lottoPrize) {
    return result.get(lottoPrize);
  }

  public String buildResultMessage(LottoPrize lottoPrize) {
    int matchedLottoCount = getMatchedLottoCount(lottoPrize);
    return lottoPrize.buildPrizeMessage()
        + String.format(MESSAGE_FOR_MATCHED_LOTTO_COUNT, matchedLottoCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result other = (Result) o;
    return result.equals(other.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}
