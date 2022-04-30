package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;
import lotto.strategy.NumberGenerateStrategy;

public class LottoNumbers {

  private static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    validateDuplicateNumber(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public static LottoNumbers create(NumberGenerateStrategy numberGenerateStrategy) {
    return new LottoNumbers(numberGenerateStrategy.generate());
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }


  private void validateDuplicateNumber(List<LottoNumber> lottoNumbers) {
    Set<Integer> validateLottoNumbers = new HashSet<>();
    for (LottoNumber lottoNumber : lottoNumbers) {
      validateLottoNumbers.add(lottoNumber.getValue());
    }
    if (validateLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new LottoNumberDuplicateException();
    }
  }
}
