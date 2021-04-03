package lotto.exception;

public class MoreManualLottoException extends LottoException {

  public static final String INVALID_MANUAL_LOTTO_COUNT = "구매한 로또 개수보다 수동으로 더 많이 구매할 수 없습니다.";

  public MoreManualLottoException() {
    super(INVALID_MANUAL_LOTTO_COUNT);
  }
}
