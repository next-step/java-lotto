package lotto.domain;

public final class Lotto {

  private final LottoNumbers lottoNumbers;

  public Lotto() {
    lottoNumbers = new LottoNumbers();
  }

  public Lotto(String[] winningNumbers) {
    lottoNumbers = new LottoNumbers(winningNumbers);
  }

  public int lottoNumbersSize() {
    return lottoNumbers.size();
  }

  public int compare(Lotto winningLotto) {
    return lottoNumbers.compare(winningLotto.lottoNumbers);
  }
}
