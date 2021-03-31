package step2.service;

import step2.domain.Lotto;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;
import step2.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
  private final List<LottoNumber> lottoNumbers;

  private final int STARTING_NUMBER = 1;
  private final int LAST_NUMBER = 45;

  public LottoMaker() {
    lottoNumbers = new ArrayList<>();
    for (int i = STARTING_NUMBER; i <= LAST_NUMBER; i++) {
      lottoNumbers.add(new LottoNumber(i));
    }
    Collections.unmodifiableList(lottoNumbers);
  }

  public Lotto makeLotto(LottoStrategy lottoStrategy) {
    LottoNumbers lottoNumbers = new LottoNumbers(lottoStrategy.markingNumbers(this.lottoNumbers));
    return new Lotto(lottoNumbers);
  }
}
