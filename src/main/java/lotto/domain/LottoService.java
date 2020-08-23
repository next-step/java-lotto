package lotto.domain;

import lotto.utils.LottoValidationUtils;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public int buyLottoTicket(int price) {
        LottoValidationUtils.invalidLottoTicketInputPrice(price, LOTTO_TICKET_PRICE);
        return price / LOTTO_TICKET_PRICE;
    }

}
