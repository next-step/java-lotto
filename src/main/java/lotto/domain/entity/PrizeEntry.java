package lotto.domain.entity;

import java.util.Map;
import java.util.stream.Stream;

public class PrizeEntry {

  private static final String NULL_MESSAGE = "null이 입력되었습니다.";

  private final Map<Prize, Integer> entry;

  public PrizeEntry(Map<Prize, Integer> entry) {
    if (entry == null) {
      throw new IllegalArgumentException(NULL_MESSAGE);
    }
    this.entry = entry;
  }

  public Stream<Map.Entry<Prize, Integer>> stream() {
    return entry.entrySet().stream();
  }
}
