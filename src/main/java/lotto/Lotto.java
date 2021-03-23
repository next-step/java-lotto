package lotto;

public final class Lotto {

  private final LottoNumbers lottoNumbers;

  public Lotto() {
    lottoNumbers = new LottoNumbers();
  }

  public Lotto(String[] winningNumbers) {
    lottoNumbers = null;
  }

  public int lottoNumbersSize() {
    return lottoNumbers.size();
  }
}
