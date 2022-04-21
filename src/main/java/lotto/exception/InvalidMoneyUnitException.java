package lotto.exception;

public class InvalidMoneyUnitException extends RuntimeException {

    private static final String INVALID_MONEY_UNIT_MESSAGE_FORMAT = "로또 금액은 1000원 단위로 입력해주세요 : %d";

    public InvalidMoneyUnitException(long money) {
        super(String.format(INVALID_MONEY_UNIT_MESSAGE_FORMAT, money));
    }

}
