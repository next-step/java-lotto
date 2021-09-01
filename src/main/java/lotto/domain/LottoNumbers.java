package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lotto.exception.InvalidLottoSizeException;

public class LottoNumbers {

  public static final int SIZE = 6;

  private final Set<LottoNumber> lottoNumbers;

  public LottoNumbers(int[] numbers) {
    this(
        Arrays.stream(numbers).boxed()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
  }

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

  public boolean contains(LottoNumber lottoNumber) {
    return this.lottoNumbers.contains(lottoNumber);
  }

  private void validateSize() {
    if (this.lottoNumbers.size() != SIZE) {
      throw new InvalidLottoSizeException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }
}
