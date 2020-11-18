package lotto.domain.model;

import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.WinnerLotto;

import java.util.List;
import java.util.Objects;

public class LottoGames {

  private final List<Lotto> lottos;

  public LottoGames(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> getLottoGames() {
    return lottos;
  }

  public int getGameSize() {
    return lottos.size();
  }

  public LottoResults confirmPrize(WinnerLotto winnerLotto) {
    return new LottoResults(winnerLotto.prizeResult(lottos));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoGames that = (LottoGames) o;
    return lottos.equals(that.lottos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottos);
  }
}
