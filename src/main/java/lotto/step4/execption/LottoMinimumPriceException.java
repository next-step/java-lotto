package lotto.step4.execption;

public class LottoMinimumPriceException extends RuntimeException {

  private static String ERROR_MESSAGE = "구입 금액은 최소 1000원 이상 필요합니다.";

  public LottoMinimumPriceException() {
    super(ERROR_MESSAGE);
  }
}
