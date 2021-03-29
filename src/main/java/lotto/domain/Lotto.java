package lotto.domain;

import lotto.RandomLottoNumberCreationStrategy;

public final class Lotto {

  public static final int PRICE = 1000;

  private final LottoNumbers lottoNumbers;

  public Lotto() {
    lottoNumbers = new LottoNumbers(new RandomLottoNumberCreationStrategy());
  }

  public Lotto(String[] numbers) {
    lottoNumbers = new LottoNumbers(numbers);
  }

  public int lottoNumbersSize() {
    return lottoNumbers.size();
  }

  public Match compare(Lotto winningLotto, LottoNumber bonusNumber) {
    return lottoNumbers.compare(winningLotto.lottoNumbers, bonusNumber);
  }

  public LottoNumbers getLottoNumbers() {
    return lottoNumbers;
  }
}
