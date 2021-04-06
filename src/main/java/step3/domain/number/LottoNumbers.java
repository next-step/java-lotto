package step3.domain.number;

import step3.exception.DuplicatedLottoNumberException;
import step3.exception.InvalidNumbersSizeException;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
  private static final int STANDARD_SIZE = 6;
  private static final String SIZE_ERROR_MESSAGE = "숫자 개수가 일치하지 않습니다.";
  private static final String DUPLICATED_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != STANDARD_SIZE) {
      throw new InvalidNumbersSizeException(SIZE_ERROR_MESSAGE);
    }

    if (distinctSize(lottoNumbers) != STANDARD_SIZE) {
      throw new DuplicatedLottoNumberException(DUPLICATED_ERROR_MESSAGE);
    }

    this.lottoNumbers = lottoNumbers;
  }

  private Long distinctSize(List<LottoNumber> lottoNumbers) {
    return lottoNumbers.stream().distinct().count();
  }

  public void sort() {
    Collections.sort(lottoNumbers);
  }

  public LottoMatchingCount matchNumbers(LottoNumbers targetLottoNumbers) {
    int result = targetLottoNumbers
      .lottoNumbers
      .stream()
      .filter(lottoNumbers::contains)
      .mapToInt(e -> 1)
      .sum();

    return new LottoMatchingCount(result);
  }

  public boolean matchSpecificNumber(LottoNumber targetLottoNumber) {
    boolean result = false;
    if (lottoNumbers.contains(targetLottoNumber)) {
      result = true;
    }
    return result;
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
