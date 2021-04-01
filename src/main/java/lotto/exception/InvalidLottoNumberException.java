package lotto.exception;

public class InvalidLottoNumberException extends LottoException {

  public static final String INVALID_LOTTO_NUMBER = "유효한 로또 번호가 아닙니다.";

  public InvalidLottoNumberException() {
    super(INVALID_LOTTO_NUMBER);
  }
}
