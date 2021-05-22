package lotto.domain;

import lotto.enums.Rank;
import lotto.input.WinningNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static lotto.enums.Rank.FIFTH;
import static lotto.enums.Rank.FIRST;
import static lotto.enums.Rank.FOURTH;
import static lotto.enums.Rank.MISS;
import static lotto.enums.Rank.SECOND;
import static lotto.enums.Rank.THIRD;

public final class LottoBucket {

  private final List<Lotto> lottos;

  public LottoBucket(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public MatchNumberCount getMatchNumberCountWith(WinningNumber winningNumber) {
    Map<Rank, Integer> count = getDefaultCount();

    for (Lotto lotto : lottos) {
      Rank rank = lotto.getRankBy(winningNumber);
      count.put(rank, count.get(rank) + 1);
    }

    return new MatchNumberCount(count);
  }

  private Map<Rank, Integer> getDefaultCount() {
    return new HashMap<Rank, Integer>() {{
      put(FIRST, 0);
      put(SECOND, 0);
      put(THIRD, 0);
      put(FOURTH, 0);
      put(FIFTH, 0);
      put(MISS, 0);
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
