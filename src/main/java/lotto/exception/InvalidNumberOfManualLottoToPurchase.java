package lotto.exception;

public class InvalidNumberOfManualLottoToPurchase extends IllegalArgumentException {
    private static final String WRONG_NUMBER_OF_MANUAL_LOTTO_TO_PURCHASE_MESSAGE = "(%s): 잘못된 로또 구매 수 입니다.";

    public InvalidNumberOfManualLottoToPurchase(int wrongInput) {
        this(String.valueOf(wrongInput));
    }

    public InvalidNumberOfManualLottoToPurchase(String wrongInput) {
        super(String.format(WRONG_NUMBER_OF_MANUAL_LOTTO_TO_PURCHASE_MESSAGE, wrongInput));
    }
}
