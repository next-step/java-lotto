package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  public static final int LOTTO_SIZE = 6;
  public static final int PRICE_PER_LOTTO = 1_000;
  private static final String NOT_VALID_NUMBERS_SIZE = "로또번호는 6개의 정수로 구성되어야 합니다.";
  private static final String CONTAINS_DUPLICATE_LOTTO_NUMBER = "로또번호에 중복된 숫자가 존재합니다.";

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
