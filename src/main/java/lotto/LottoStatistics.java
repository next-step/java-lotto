package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoStatistics {
  private final Map<Integer, Integer> statistics;

  public LottoStatistics() {
    statistics = new HashMap<>();
    statistics.put(3, 0);
    statistics.put(4, 0);
    statistics.put(5, 0);
    statistics.put(6, 0);
  }

  public void increment(int matchCount) {
    if (matchCount >= 3) {
      statistics.put(matchCount, statistics.get(matchCount) + 1);
    }
  }

  public Map<Integer, Integer> getStatistics() {
    return statistics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoStatistics that = (LottoStatistics) o;
    return Objects.equals(statistics, that.statistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statistics);
  }
}
