package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos manualLottos(List<String> manualNumbers) {
    return new Lottos(manualNumbers.stream().map(Lotto::new).toList());
  }

  public int count() {
    return lottos.size();
  }

  public LottoMatchResult matchResult(WinningNumbers winningNumbers) {
    LottoMatchResult result = new LottoMatchResult();
    for (Lotto lotto : lottos) {
      result.match(winningNumbers.matchingRank(lotto));
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
