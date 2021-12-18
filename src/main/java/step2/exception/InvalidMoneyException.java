package step2.exception;

public class InvalidMoneyException extends IllegalArgumentException{
    private static final String INVALID_MONEY = "금액은 0원 이상 가능합니다. 현재 금액 : %d";

    public InvalidMoneyException(long input) {
        super(String.format(INVALID_MONEY, input));
    }
}
