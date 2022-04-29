package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.NumberGenerator;

public class LottoNumbers {

  private final List<LottoNumber> lottoNumbers;
  public static final String LOTTO_NUMBER_DELIMITER = ",";

  public LottoNumbers(String lottoNumbers) {
    this.lottoNumbers = new ArrayList<>();
    for (String lottoNumber : lottoNumbers.split(LOTTO_NUMBER_DELIMITER)) {
      this.lottoNumbers.add(new LottoNumber(lottoNumber));
    }
  }

  public LottoNumbers(int numberCount, NumberGenerator numberGenerator) {
    this.lottoNumbers = new ArrayList<>();
    for (int i = 0; i < numberCount; i++) {
      this.lottoNumbers.add(new LottoNumber(numberGenerator.generate()));
    }
  }

  public LottoNumbers getMatchNumbers(LottoNumbers winNumbers) {
    lottoNumbers.retainAll(winNumbers.lottoNumbers);
    return this;
  }

  public int getNumberSize() {
    return lottoNumbers.size();
  }
}
