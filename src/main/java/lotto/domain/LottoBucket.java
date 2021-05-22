package lotto.domain;

import lotto.input.WinningNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class LottoBucket {

  private final List<Lotto> lottos;

  public LottoBucket(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public MatchNumberCount getMatchNumberCountWith(WinningNumber winningNumber) {
    Map<Integer, Integer> count = getDefaultCount();

    for (Lotto lotto : lottos) {
      int matchCount = lotto.getMatchCountFrom(winningNumber);
      if (matchCount >= 3) {
        count.put(matchCount, count.get(matchCount) + 1);
      }
    }

    return new MatchNumberCount(count);
  }

  private Map<Integer, Integer> getDefaultCount() {
    return new HashMap<Integer, Integer>() {{
      put(3, 0);
      put(4, 0);
      put(5, 0);
      put(6, 0);
    }};
  }

  public int size() {
    return lottos.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoBucket that = (LottoBucket) o;
    return Objects.equals(lottos, that.lottos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottos);
  }
}
