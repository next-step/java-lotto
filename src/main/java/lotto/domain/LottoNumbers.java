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

  public LottoNumbers(NumberGenerator numberGenerator) {
    this.values = new ArrayList<>();
    List<Integer> numbers = numberGenerator.generate();
    for (Integer number : numbers) {
      this.values.add(new LottoNumber(number));
    }
  }

  private LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.values = lottoNumbers;
  }

  public LottoNumbers getMatchNumbers(LottoNumbers winNumbers) {
    ArrayList<LottoNumber> numbers = new ArrayList<>(values);
    numbers.retainAll(winNumbers.values);
    return new LottoNumbers(numbers);
  }

  public int getNumberSize() {
    return values.size();
  }

  public List<LottoNumber> getValues() {
    return Collections.unmodifiableList(values);
  }

  public boolean isBonusMatch(LottoNumber bonusNumber) {
    if (bonusNumber == null) {
      return false;
    }
    return values.contains(bonusNumber);
  }
}
