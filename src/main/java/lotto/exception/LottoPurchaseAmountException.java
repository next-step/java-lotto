package lotto.exception;

/*
사용자가 로또 구입 금액을 잘못 입력 했을때 발생하는 예외.
 */
public class LottoPurchaseAmountException extends RuntimeException{
    private static final String INVALID_LOTTO_PURCHASE_AMOUNT = "로또 구입 금액이 잘못 되었습니다.";

    public LottoPurchaseAmountException() {
        super(INVALID_LOTTO_PURCHASE_AMOUNT);
    }
}
