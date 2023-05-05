package lotto.domain.game;

import java.util.List;

public class LottoGameWrapper {
  private final LottoGame game;
  private final List<LottoGameType> includeGameTypes;

  public LottoGameWrapper(LottoGame game, List<LottoGameType> includeGameTypes) {
    this.game = game;
    this.includeGameTypes = includeGameTypes;
  }

  public LottoGame getGame() {
    return game;
  }

  public List<LottoGameType> getIncludeGameTypes() {
    return includeGameTypes;
  }
}
