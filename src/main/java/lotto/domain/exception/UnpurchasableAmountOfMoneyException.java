package lotto.domain.exception;

public class UnpurchasableAmountOfMoneyException extends RuntimeException {

    private static final UnpurchasableAmountOfMoneyException NOT_THOUSAND_UNITS_MONEY_EXCEPTION =
            new UnpurchasableAmountOfMoneyException("구매할 수 없는 금액입니다.");

    private UnpurchasableAmountOfMoneyException(String message) {
        super(message);
    }

    public static UnpurchasableAmountOfMoneyException getInstance() {
        return NOT_THOUSAND_UNITS_MONEY_EXCEPTION;
    }
}
