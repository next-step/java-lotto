package lotto.exception;

import lotto.domain.Cash;

public class InvalidCash extends IllegalArgumentException {

    private static final String MESSAGE = "%d원 이상이여야 합니다.";

    public InvalidCash() {
        super(String.format(MESSAGE, Cash.LOTTO_PRICE));
    }
}
