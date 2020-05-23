package step2.exception;

public class LottoReduplicateException extends RuntimeException {

  private static String ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

  public LottoReduplicateException() {
    super(ERROR_MESSAGE);
  }
}
