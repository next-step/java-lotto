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

  public static LottoGames from(List<NumberGenerator> numberGenerators) {
    List<LottoGame> lottoGames = numberGenerators.stream()
        .map(numberGenerator -> LottoGame.from(numberGenerator))
        .collect(Collectors.toList());
    return new LottoGames(lottoGames);
  }

  public LottoRewords draw(LottoNumbers winNumbers, LottoNumber bonusNumber) {
    List<LottoReword> lottoRewords = new ArrayList<>();
    for (LottoGame lottoGame : values) {
      lottoRewords.add(lottoGame.draw(winNumbers, bonusNumber));
    }
    return LottoRewords.from(lottoRewords);
  }

  public List<LottoGame> getValues() {
    return Collections.unmodifiableList(values);
  }
}
