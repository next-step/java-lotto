package lotto.exception;

import lotto.domain.LottoNumber;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {

  public InvalidLottoNumberRangeException() {
    super("생성 가능한 로또 번호는 " + LottoNumber.MIN + "부터 " + LottoNumber.MAX + "까지입니다.");
  }
}
