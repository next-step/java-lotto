package lotto.exception;

public class NegativeLottoCountException extends LottoException {

  public static final String INVALID_LOTTO_COUNT = "로또의 개수는 음수일 수 없습니다.";

  public NegativeLottoCountException() {
    super(INVALID_LOTTO_COUNT);
  }
}
