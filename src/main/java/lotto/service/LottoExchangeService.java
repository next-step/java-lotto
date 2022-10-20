package lotto.service;

import lotto.domain.LottoTickets;
import lotto.exception.InvalidInputException;

public class LottoExchangeService {

    private static final Integer LOTTO_PRICE = 1000;
    private static final String INVALID_UNIT = LOTTO_PRICE + " 단위의 숫자만 입력할 수 있습니다.";

    public LottoTickets purchaseLottoTickets(Integer purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new InvalidInputException(INVALID_UNIT);
        }
        return new LottoTickets(purchasePrice / LOTTO_PRICE, purchasePrice);
    }

}
