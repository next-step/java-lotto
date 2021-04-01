package lotto.exception;

public class InvalidMatchCountException extends LottoException {

  public static final String INVALID_MATCH_COUNT = "로또 숫자보다 일치하는 갯수가 많을 수 없습니다.";

  public InvalidMatchCountException() {
    super(INVALID_MATCH_COUNT);
  }
}
