package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;
import lotto.strategy.NumberGenerateStrategy;

public class Lotto {

  public static final int PRICE_OF_ONE_LOTTO = 1000;
  private static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> lottoNumbers;

  public Lotto(List<LottoNumber> lottoNumbers) {
    validateDuplicateNumber(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto create(NumberGenerateStrategy numberGenerateStrategy) {
    return new Lotto(numberGenerateStrategy.generate());
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  private void validateDuplicateNumber(List<LottoNumber> lottoNumbers) {
    Set<LottoNumber> validateLottoNumbers = new HashSet<>(lottoNumbers);
    if (validateLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new LottoNumberDuplicateException(lottoNumbers);
    }
  }

  public int matchWinningLottoNumbers(WinningLotto winningLottoNumbers) {
    return Math.toIntExact(lottoNumbers.stream()
        .filter(winningLottoNumbers::contains)
        .count());
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
