package lotto.step4.execption;

public class LottoLesserPriceException extends RuntimeException {

  private static String ERROR_MESSAGE = "직접 구매하는 로또의 갯수가 로또 구매 금액을 초과했습니다.";

  public LottoLesserPriceException() {
    super(ERROR_MESSAGE);
  }
}
