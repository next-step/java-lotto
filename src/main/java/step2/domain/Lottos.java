package step2.domain;

import step2.domain.number.Count;
import step2.domain.result.LottoMatchingResult;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private final List<Lotto> lottos;

  public Lottos() {
    lottos = new ArrayList<>();
  }

  public void addLotto(Lotto lotto) {
    lottos.add(lotto);
  }

  public Count quantity() {
    return new Count(lottos.size());
  }

  public LottoMatchingResult matchLottos(Lotto prizeLotto) {
    LottoMatchingResult lottoMatchingResult = new LottoMatchingResult();
    for (Lotto targetLotto : lottos) {
      lottoMatchingResult.add(targetLotto.matchLotto(prizeLotto));
    }

    return lottoMatchingResult;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottos) {
      sb.append(lotto.toString()).append(System.lineSeparator());
    }
    return sb.toString();
  }
}
