package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  public static final Money PRICE = new Money(1000);

  LottoNumbers lottoNumbers;

  private Lotto(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = new LottoNumbers(lottoNumbers);
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

  public int matchNumberCnt(LottoNumbers winningLottoNumbers) {
    return this.lottoNumbers.matchedNumberCnt(winningLottoNumbers);
  }

  // TODO: remove
//  public int matchedNumberCnt(Lotto winningLotto) {
//    return this.lottoNumbers.matchedNumberCnt(winningLotto.lottoNumbers);
//  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public List<Integer> sortedNumbers() {
    return this.lottoNumbers.sortedNumbers();
  }
}
