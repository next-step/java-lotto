package lotto.exception;

public class LottoNumberDuplicateException extends IllegalArgumentException{
  private static final String LOTTO_NUMBER_DUPLICATION_ERR_MSG = "로또 번호는 중복될 수 없습니다.";

  public LottoNumberDuplicateException() {
    super(LOTTO_NUMBER_DUPLICATION_ERR_MSG);
  }
}
