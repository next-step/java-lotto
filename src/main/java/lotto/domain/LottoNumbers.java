package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.strategy.NumberGenerator;

public class LottoNumbers {

  private final List<LottoNumber> values;
  public static final String LOTTO_NUMBER_DELIMITER = ",";

  public LottoNumbers(String lottoNumbers) {
    this.values = new ArrayList<>();
    for (String lottoNumber : lottoNumbers.split(LOTTO_NUMBER_DELIMITER)) {
      this.values.add(new LottoNumber(lottoNumber.trim()));
    }
  }

  public LottoNumbers(int numberCount, NumberGenerator numberGenerator) {
    this.values = new ArrayList<>();
    for (int i = 0; i < numberCount; i++) {
      this.values.add(new LottoNumber(numberGenerator.generate()));
    }
  }

  public LottoNumbers getMatchNumbers(LottoNumbers winNumbers) {
    values.retainAll(winNumbers.values);
    return this;
  }

  public int getNumberSize() {
    return values.size();
  }

  public List<LottoNumber> getValues() {
    return Collections.unmodifiableList(values);
  }
}
