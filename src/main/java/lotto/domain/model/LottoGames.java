package lotto.domain.model;

import lotto.constants.PrizeGrade;
import lotto.domain.LottoGame;
import lotto.domain.LottoResults;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

  public LottoResults confirmPrize(LottoGame lastWeekWinGame) {
    return new LottoResults(getConfirmResults(lastWeekWinGame));
  }

  private List<PrizeGrade> getConfirmResults(LottoGame lastWeekWinGame) {
    return lottoGames.stream()
        .map(lottoGame -> lottoGame.confirmPrize(lastWeekWinGame))
        .collect(Collectors.toList());
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
