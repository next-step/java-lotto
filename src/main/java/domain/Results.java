package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Results {
  private final List<Result> results;

  public Results(List<Result> results) {
    this.results = results;
  }

  public Map<Result, PositiveNumber> stats() {
    Map<Result, PositiveNumber> stats = new HashMap<>();
    return this.results.stream()
            .filter(Result::win)
            .reduce(stats, this::resultCountMap, this::combinedResultCountMap);
  }

  private Map<Result, PositiveNumber> resultCountMap(final Map<Result, PositiveNumber> acc, final Result cur) {
    if (acc.get(cur) == null) {
      acc.put(cur, PositiveNumber.of(1));
      return acc;
    }
    acc.put(cur, acc.get(cur).increment());
    return acc;
  }

  private Map<Result, PositiveNumber> combinedResultCountMap(final Map<Result, PositiveNumber> map1, final Map<Result, PositiveNumber> map2) {
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
