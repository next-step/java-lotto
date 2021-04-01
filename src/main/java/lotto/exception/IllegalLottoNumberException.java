package lotto.exception;

public class IllegalLottoNumberException extends LottoException {

  public static final String ILLEGAL_LOTTO_NUMBER = "유효한 로또 번호가 아닙니다.";

  public IllegalLottoNumberException() {
    super(ILLEGAL_LOTTO_NUMBER);
  }
}
