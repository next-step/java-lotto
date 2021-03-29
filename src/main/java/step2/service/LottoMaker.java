package step2.service;

import step2.domain.Lotto;
import step2.domain.number.Number;
import step2.domain.number.Numbers;
import step2.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
  private final List<Number> lottoNumbers;

  private final int STARTING_NUMBER = 1;
  private final int LAST_NUMBER = 45;

  public LottoMaker() {
    lottoNumbers = new ArrayList<>();
    for (int i = STARTING_NUMBER; i <= LAST_NUMBER; i++) {
      lottoNumbers.add(new Number(i));
    }
  }

  public Lotto makeLotto(LottoStrategy lottoStrategy) {
    Numbers numbers = new Numbers(lottoStrategy.markingNumbers(lottoNumbers));
    return new Lotto(numbers);
  }
}
