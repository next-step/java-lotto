package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Results {
  private final List<Result> results;

  public Results(List<Result> results) {
    this.results = results;
  }

  public Map<Prize, PositiveNumber> stats() {
    Map<Prize, PositiveNumber> stats = new HashMap<>();
    return this.results.stream()
            .map(Prize::from)
            .filter(Prize::valid)
            .reduce(stats, this::prizeCountMap, this::combinedPrizeCountMap);
  }

  private Map<Prize, PositiveNumber> prizeCountMap(final Map<Prize, PositiveNumber> acc, final Prize cur) {
    if (acc.get(cur) == null) {
      acc.put(cur, PositiveNumber.of(1));
      return acc;
    }
    acc.put(cur, acc.get(cur).increment());
    return acc;
  }

  private Map<Prize, PositiveNumber> combinedPrizeCountMap(final Map<Prize, PositiveNumber> map1, final Map<Prize, PositiveNumber> map2) {
    map1.putAll(map2);
    return map1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Results results1 = (Results) o;
    return results.equals(results1.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }
}
