package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

  public static final Money PRICE = new Money(1000);

  private final LottoNumbers lottoNumbers;

  private Lotto(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto issueByManual(List<Integer> numbers) {
    LottoNumbers lottoNumbers = new LottoNumbers(
        numbers.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
    return new Lotto(lottoNumbers);
  }

  public static Lotto issueByManual(int[] numbers) {
    return new Lotto(new LottoNumbers(numbers));
  }

  public static Lotto issueByAuto() {
    return new Lotto(LottoNumbersGenerator.generateByRandom());
  }

  public int matchNumberCnt(LottoNumbers winningLottoNumbers) {
    return lottoNumbers.matchedNumberCnt(winningLottoNumbers);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public List<Integer> sortedNumbers() {
    return lottoNumbers.sortedNumbers();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }
}
