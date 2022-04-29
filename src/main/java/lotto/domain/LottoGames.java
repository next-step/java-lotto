package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.NumberGenerator;

public class LottoGames {

  private final List<LottoGame> values;

  public LottoGames(int gameCount, List<NumberGenerator> numberGenerator) {
    values = new ArrayList<>();
    for (int i = 0; i < gameCount; i++) {
      values.add(new LottoGame(numberGenerator.get(i)));
    }
  }

  public LottoDrawResults draw(LottoNumbers winNumbers) {
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    for (LottoGame lottoGame : values) {
      lottoDrawResults.add(lottoGame.draw(winNumbers));
    }
    return new LottoDrawResults(lottoDrawResults);
  }

}
