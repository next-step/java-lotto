package step3.exception;

public class MoneyRangeNegativeException extends RuntimeException {

    private static final String RANGE_VIOLATION_ERROR_MESSAGE = "돈은 양수여야 합니다. 입력된 돈 = ";

    public MoneyRangeNegativeException(long inputMoney) {
        super(RANGE_VIOLATION_ERROR_MESSAGE + inputMoney);
    }
}
