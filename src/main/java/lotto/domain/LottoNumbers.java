package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

  private final List<LottoNumber> values;
  public static final String LOTTO_NUMBER_DELIMITER = ",";

  private LottoNumbers(List<LottoNumber> values) {
    this.values = values;
  }

  public static LottoNumbers of(List<Integer> lottoNumbers) {
    List<LottoNumber> values = new ArrayList<>();
    for (Integer number : lottoNumbers) {
      values.add(LottoNumber.of(number));
    }
    return new LottoNumbers(values);
  }

  public static LottoNumbers of(String lottoNumbers) {
    List<LottoNumber> values = new ArrayList<>();
    for (String lottoNumber : lottoNumbers.split(LOTTO_NUMBER_DELIMITER)) {
      values.add(LottoNumber.of(lottoNumber.trim()));
    }
    return new LottoNumbers(values);
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
