package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public Map<Integer, Integer> calculateMatchCounts(Lotto winningNumbers) {
    Map<Integer, Integer> result = new HashMap<>();
    for (Lotto lotto : lottos) {
      int match = lotto.countMatchingNumbers(winningNumbers);
      result.put(match, result.getOrDefault(match, 0) + 1);
    }
    return result;
  }

}
