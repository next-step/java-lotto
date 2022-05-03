package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.strategy.NumberGenerator;

public class LottoGames {

  private final List<LottoGame> values;

  private LottoGames(List<LottoGame> values) {
    this.values = values;
  }

  public static LottoGames of(List<NumberGenerator> numberGenerators) {
    List<LottoGame> lottoGames = numberGenerators.stream()
        .map(numberGenerator -> LottoGame.of(numberGenerator))
        .collect(Collectors.toList());
    return new LottoGames(lottoGames);
  }

  public LottoDrawResults draw(LottoNumbers winNumbers, LottoNumber bonusNumber) {
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    for (LottoGame lottoGame : values) {
      lottoDrawResults.add(lottoGame.draw(winNumbers, bonusNumber));
    }
    return new LottoDrawResults(lottoDrawResults);
  }

  public List<LottoGame> getValues() {
    return Collections.unmodifiableList(values);
  }
}
