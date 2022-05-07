package lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Result {

  private final Map<LottoPrize, Integer> result;

  Result() {
    this.result = new EnumMap<>(LottoPrize.class);
  }

  Result(Map<LottoPrize, Integer> result) {
    this.result = result;
  }

  public void add(LottoPrize lottoPrize) {
    result.merge(lottoPrize, 1, Integer::sum);
  }

  public int getMatchedLottoCount(LottoPrize lottoPrize) {
    return result.getOrDefault(lottoPrize, 0);
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
