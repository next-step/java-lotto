package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;

public class TestRandomNumberGenerateStrategy implements RandomNumberGenerateStrategy {

  private final List<LottoNumber> testNumbers;

  public TestRandomNumberGenerateStrategy(List<LottoNumber> testNumbers) {
    this.testNumbers = testNumbers;
  }

  @Override
  public LottoNumbers generateNewNumbers() {
    return new LottoNumbers(testNumbers);
  }
}
