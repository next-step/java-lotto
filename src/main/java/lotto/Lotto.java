package lotto;

public class Lotto {

  private LottoNumbers lottoNumbers;

  public Lotto() {
    System.out.println("#####");
    this.lottoNumbers = new NumbersBox().getLottoNumbers();
  }

  public LottoNumbers getNumbers() {
    return lottoNumbers;
  }
}
