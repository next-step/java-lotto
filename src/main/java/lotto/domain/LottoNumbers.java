package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.InvalidLottoNumbersException;

public class LottoNumbers {

  public static final int NUMBER_COUNT = 6;
  private final List<LottoNumber> values;
  public static final String LOTTO_NUMBER_DELIMITER = ",";

  private LottoNumbers(List<LottoNumber> values) {
    if (values.size() != NUMBER_COUNT) {
      throw new InvalidLottoNumbersException(NUMBER_COUNT);
    }
    this.values = values;
  }

  public static LottoNumbers from(List<Integer> lottoNumbers) {
    List<LottoNumber> values = new ArrayList<>();
    for (Integer number : lottoNumbers) {
      values.add(LottoNumber.from(number));
    }
    return new LottoNumbers(values);
  }

  public static LottoNumbers from(String lottoNumbers) {
    List<LottoNumber> values = new ArrayList<>();
    for (String lottoNumber : lottoNumbers.split(LOTTO_NUMBER_DELIMITER)) {
      values.add(LottoNumber.from(lottoNumber.trim()));
    }
    return new LottoNumbers(values);
  }

  public int getMatchNumbers(LottoNumbers winNumbers) {
    ArrayList<LottoNumber> numbers = new ArrayList<>(values);
    numbers.retainAll(winNumbers.values);
    return numbers.size();
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
