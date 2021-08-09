package lotto.exception;

import static lotto.domain.model.money.LottoMoney.LOTTO_PRICE;

public class InvalidLottoMoneyException extends RuntimeException {

    private static final String INVALID_AMOUNT_MESSAGE = String.format(
            "로또 구입 금액은 %d의 배수인 양수이어야 합니다.", LOTTO_PRICE);

    public InvalidLottoMoneyException() {
        this(INVALID_AMOUNT_MESSAGE);
    }

    public InvalidLottoMoneyException(String message) {
        super(message);
    }
}
