package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  public static final int LOTTO_SIZE = 6;
  private static final String NOT_VALID_NUMBERS_SIZE = "로또번호는 6개의 정수로 구성되어야 합니다.";
  public static final Money PRICE_PER_LOTTO = new Money(1_000);

  private final List<LottoNumber> lottoNumbers;

  public Lotto() {
    this.lottoNumbers = LottoRandomMachine.makeRandomLottoNumbers();
  }

  public Lotto(List<LottoNumber> lottoNumbers) {
    checkLottoSize(lottoNumbers.size());
    this.lottoNumbers = lottoNumbers;
  }

  private void checkLottoSize(int size) {
    if (size != LOTTO_SIZE) {
      throw new IllegalArgumentException(NOT_VALID_NUMBERS_SIZE);
    }
  }

  public List<LottoNumber> getLottoNumbers() {
    return new ArrayList(lottoNumbers);
  }

}
