package lotto;

public final class Lotto {

  private final LottoNumbers lottoNumbers;

  public Lotto() {
    lottoNumbers = new LottoNumbers();
  }

  public int lottoNumbersSize() {
    return lottoNumbers.size();
  }
}
