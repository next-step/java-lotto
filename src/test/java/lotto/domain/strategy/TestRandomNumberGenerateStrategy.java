package lotto.domain.strategy;

import lotto.domain.LottoNumbers;
import lotto.util.TestUtil;

public class TestRandomNumberGenerateStrategy implements RandomNumberGenerateStrategy {

  @Override
  public LottoNumbers generateNewNumbers() {
    return new LottoNumbers(TestUtil.getOneToSixLottoNumbers());
  }
}
