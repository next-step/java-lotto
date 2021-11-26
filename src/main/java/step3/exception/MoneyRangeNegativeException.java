package step3.exception;

import static java.lang.String.format;

import step3.model.Money;

public class MoneyRangeNegativeException extends RuntimeException {

    private static final String RANGE_VIOLATION_ERROR_MESSAGE = "돈은 %d 보다 같거나 커야 합니다. 입력된 돈 = %d";

    public MoneyRangeNegativeException(long inputMoney) {
        super(format(RANGE_VIOLATION_ERROR_MESSAGE, Money.MIN, inputMoney));
    }
}
