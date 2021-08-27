package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.InvalidLottoSizeException;

public class Lotto {

  public static final Money PRICE = new Money(1000);
  public static final int NUMBER_SIZE = 6;

  private final Set<LottoNumber> lottoNumbers;

  private Lotto(List<LottoNumber> lottoNumbers) {
    validateLottoNumbers(lottoNumbers);
    this.lottoNumbers = new TreeSet<>(lottoNumbers);
  }

  public static Lotto issueByManual(List<Integer> numbers) {
    return new Lotto(
        numbers.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
  }

  public static Lotto issueByAuto() {
    return new Lotto(LottoNumbersGenerator.generateByRandom());
  }

  public int matchedNumberCnt(Lotto winningLotto) {
    return (int) lottoNumbers.stream()
        .filter(winningLotto.lottoNumbers::contains)
        .count();
  }

  public List<Integer> numbers() {
    return lottoNumbers.stream()
        .map(LottoNumber::number)
        .collect(Collectors.toList());
  }

  private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != NUMBER_SIZE) {
      throw new InvalidLottoSizeException();
    }
    if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
      throw new DuplicatedLottoNumberException();
    }
  }
}
