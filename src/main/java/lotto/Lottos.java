package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public int count() {
    return lottos.size();
  }

  public LottoMatchResult matchResult(Lotto winningNumbers) {
    LottoMatchResult result = new LottoMatchResult();
    for (Lotto lotto : lottos) {
      LottoRank match = lotto.matchingRank(winningNumbers);
      result.match(match);
    }
    return result;
  }

  public List<String> toDisplayStrings() {
    List<String> lines = new ArrayList<>();
    for (Lotto lotto : lottos) {
      lines.add(lotto.toString());
    }
    return lines;
  }

}
