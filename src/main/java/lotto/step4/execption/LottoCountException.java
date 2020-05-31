package lotto.step4.execption;

public class LottoCountException extends RuntimeException {

  private static String ERROR_MESSAGE = "로또 번호의 갯수는 6개만 가능합니다.";

  public LottoCountException() {
    super(ERROR_MESSAGE);
  }
}
