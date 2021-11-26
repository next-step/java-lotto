package lotto.domain;

import lotto.domain.value.OrderPrice;

public class Store {

    private static final int LOTTO_PRICE = 1000;

    public LottoTicket purchaseTicket(OrderPrice lottoPrice) {

        return new LottoTicket(lottoPrice.getLottoPrice() / LOTTO_PRICE);
    }

}
