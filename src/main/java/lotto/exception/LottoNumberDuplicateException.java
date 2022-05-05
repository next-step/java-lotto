package lotto.exception;

import java.util.List;
import lotto.model.LottoNumber;

public class LottoNumberDuplicateException extends IllegalArgumentException {

  private static final String LOTTO_NUMBER_DUPLICATION_ERR_MSG = "입력된 로또번호는 %s으로 로또 번호는 중복될 수 없습니다.";

  public LottoNumberDuplicateException(List<LottoNumber> lottoNumbers) {
    super(String.format(LOTTO_NUMBER_DUPLICATION_ERR_MSG, lottoNumbers));
  }
}
