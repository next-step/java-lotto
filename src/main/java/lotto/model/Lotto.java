package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;
import lotto.strategy.LottoNumberGenerateStrategy;

public class Lotto {

  private static final String LOTTO_NULL_OR_EMPTY_ERROR_MESSAGE = "로또가 null이거나 empty입니다.";
  private static final String LOTTO_BASED_SPLIT_REGEX = ", ";
  public static final int PRICE_OF_ONE_LOTTO = 1000;
  public static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> lottoNumbers;

  public Lotto(List<LottoNumber> lottoNumbers) {
    validate(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto create(LottoNumberGenerateStrategy numberGenerateStrategy) {
    return new Lotto(numberGenerateStrategy.generate());
  }

  public static Lotto create(String winningLotto) {
    String[] splitLottoNumbers = splitLotto(winningLotto);
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String lottoNumber : splitLottoNumbers) {
      lottoNumbers.add(LottoNumber.create(convertToNumber(lottoNumber)));
    }

    return create(lottoNumbers);
  }

  private static Lotto create(List<LottoNumber> winningLottoNumbers) {
    return new Lotto(winningLottoNumbers);
  }

  private static String[] splitLotto(String winningLotto) {
    return winningLotto.split(LOTTO_BASED_SPLIT_REGEX);
  }

  private static int convertToNumber(String winningLottoNumber) {
    return Integer.parseInt(winningLottoNumber);
  }

  private void validate(List<LottoNumber> lottoNumbers) {
    validateNullOrEmpty(lottoNumbers);
    validateDuplicateNumber(lottoNumbers);
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  private void validateNullOrEmpty(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers == null || lottoNumbers.isEmpty()) {
      throw new IllegalArgumentException(LOTTO_NULL_OR_EMPTY_ERROR_MESSAGE);
    }
  }

  private void validateDuplicateNumber(List<LottoNumber> lottoNumbers) {
    Set<LottoNumber> validateLottoNumbers = new HashSet<>(lottoNumbers);
    if (validateLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new LottoNumberDuplicateException(lottoNumbers);
    }
  }

  public int matchWinningLottoNumbers(Lotto lotto) {
    return Math.toIntExact(lottoNumbers.stream()
        .filter(lotto::contains)
        .count());
  }

  private boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
