package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;

public class TestNumberGenerateStrategy implements NumberGenerateStrategy {

  private final List<LottoNumber> testNumbers;

  public TestNumberGenerateStrategy(List<LottoNumber> testNumbers) {
    this.testNumbers = testNumbers;
  }

  @Override
  public LottoNumbers generateNewNumbers() {
    return new LottoNumbers(testNumbers);
  }
}
