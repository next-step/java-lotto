package lotto.domain;

import java.util.List;

public class Lotto {
  static final int PRICE = 1000;

  protected final LottoNumbers numbers;

  public Lotto(List<LottoNumber> numbers) {
    this.numbers = new LottoNumbers(numbers);
  }

  public int countMatchingNumbers(WinningLotto winningLotto) {
    return (int) numbers.countMatching(winningLotto.getNumbers());
  }

  boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  public String getNumberRepresentation() {
    return "[" + numbers.format() + "]";
  }
}
