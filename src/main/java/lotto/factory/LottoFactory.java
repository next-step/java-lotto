package lotto.factory;

import lotto.domain.Lotto;
import lotto.generator.GenerateStrategy;

public class LottoFactory {
  public Lotto generate(GenerateStrategy generator) {
    return generator.generate();
  }
}
