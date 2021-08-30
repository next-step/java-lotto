package lotto.exception;

import lotto.domain.LottoNumbers;

public class InvalidLottoSizeException extends IllegalArgumentException {

  public InvalidLottoSizeException() {
    super("중복되지 않는 " + LottoNumbers.SIZE + "개의 로또숫자가 필요합니다.");
  }
}
