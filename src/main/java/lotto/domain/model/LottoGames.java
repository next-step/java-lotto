package lotto.domain.model;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameCondition;
import lotto.domain.LottoResults;

import java.util.List;
import java.util.Objects;

public class LottoGames {

  private final List<LottoGame> lottoGames;

  public LottoGames(List<LottoGame> lottoGames) {
    this.lottoGames = lottoGames;
  }

  public List<LottoGame> getLottoGames() {
    return lottoGames;
  }

  public int getGameSize() {
    return lottoGames.size();
  }

  public LottoResults confirmPrize(LottoGameCondition lottoGameCondition) {
    return new LottoResults(lottoGameCondition.prizeResult(lottoGames));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoGames that = (LottoGames) o;
    return lottoGames.equals(that.lottoGames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoGames);
  }
}
