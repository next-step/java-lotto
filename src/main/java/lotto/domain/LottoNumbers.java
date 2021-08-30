package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lotto.exception.InvalidLottoSizeException;

public class LottoNumbers {

  public static final int SIZE = 6;

  Set<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = new TreeSet<>(lottoNumbers);
    validateSize();
  }

  public List<Integer> sortedNumbers() {
    return lottoNumbers.stream()
        .map(LottoNumber::number)
        .collect(Collectors.toList());
  }

  public int matchedNumberCnt(LottoNumbers other) {
    return (int) lottoNumbers.stream()
        .filter(other.lottoNumbers::contains)
        .count();
  }

  private void validateSize() {
    if (this.lottoNumbers.size() != SIZE) {
      throw new InvalidLottoSizeException();
    }
  }
}
