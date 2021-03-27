package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGames {

  private List<LottoGame> lottoGames;

  public LottoGames(List<LottoGame> lottoGames) {
    this.lottoGames = lottoGames;
  }

  public int size() {
    return lottoGames.size();
  }

  public List<LottoGame> getLottoGames() {
    return Collections.unmodifiableList(this.lottoGames);
  }
}
