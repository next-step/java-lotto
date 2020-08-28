package lotto.domain;

import lotto.utils.LottoValidationUtils;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public int getLottoBuyCount(int price) {
        LottoValidationUtils.validateLottoTicketPrice(price, LOTTO_TICKET_PRICE);
        LottoValidationUtils.validateInputNegativeNumber(price);
        return price / LOTTO_TICKET_PRICE;
    }

}
