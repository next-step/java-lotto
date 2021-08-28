package lotto.exception;

import lotto.domain.Lotto;

public class InvalidLottoSizeException extends IllegalArgumentException {

  public InvalidLottoSizeException() {
    super("Lotto를 생성할때는 " + Lotto.NUMBER_SIZE + "개의 숫자가 필요합니다.");
  }
}
