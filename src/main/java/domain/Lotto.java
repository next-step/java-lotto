package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  public static final int LOTTO_SIZE = 6;
  public static final int PRICE_PER_LOTTO = 1_000;

  private final List<LottoNumber> lottoNumbers;

  public Lotto() {
    this.lottoNumbers = LottoRandomMachine.makeRandomLottoNumbers();
  }

  public Lotto(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<LottoNumber> getLottoNumbers() {
    return new ArrayList(lottoNumbers);
  }

}
