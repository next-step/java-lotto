package step2.domain.number;

import step2.exception.InvalidNumbersSizeException;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
  private final List<LottoNumber> lottoNumbers;

  private static final int STANDARD_SIZE = 6;
  private static final String SIZE_ERROR_MESSAGE = "숫자 개수가 일치하지 않습니다.";

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != STANDARD_SIZE) {
      throw new InvalidNumbersSizeException(SIZE_ERROR_MESSAGE);
    }
    this.lottoNumbers = lottoNumbers;
  }

  public List<LottoNumber> sort() {
    return lottoNumbers.stream().sorted(LottoNumber::compareTo).collect(Collectors.toList());
  }

  public Count matchNumbers(LottoNumbers targetLottoNumbers) {
    int result = targetLottoNumbers.lottoNumbers.stream().filter(lottoNumbers::contains).mapToInt(e -> 1).sum();
    return new Count(result);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
