package step3.exception;

public class LottoMoneyException extends IllegalArgumentException {
    private static final String LOTTO_MONEY_EXCEPTION = "로또구매시 1000원이상 지불하셔야 합니다.";

    public LottoMoneyException() {
        super(LOTTO_MONEY_EXCEPTION);
    }
}
