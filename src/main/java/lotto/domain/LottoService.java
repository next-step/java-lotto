package lotto.domain;

import lotto.exception.LottoException;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public int buyLottoTicket(int price) {
        LottoException.invalidLottoTicketInputPrice(price, LOTTO_TICKET_PRICE);
        return price / LOTTO_TICKET_PRICE;
    }

}
