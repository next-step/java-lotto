package lotto.exception;

import static java.lang.String.format;
import static lotto.domain.LottoPrice.LOTTO_PRICE;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super(format("구입금액이 로또 가격(%d원) 보다 적습니다.", LOTTO_PRICE));
    }
}
