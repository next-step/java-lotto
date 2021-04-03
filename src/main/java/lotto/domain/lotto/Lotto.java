package lotto.domain.lotto;

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

  public int countMatchNumbers(Lotto otherLotto) {
    return lottoNumbers.countMatchNumbers(otherLotto.lottoNumbers);
  }

  public LottoNumbers getLottoNumbers() {
    return lottoNumbers;
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }
}
