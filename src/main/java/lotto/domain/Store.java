package lotto.domain;

import lotto.domain.value.OrderPrice;

import java.util.List;

public class Store {

    private static final int LOTTO_PRICE = 1000;
    private static final String MANUAL_ERROR_MSG = "구매 개수보다 수동으로 더 많이 살 수 없습니다!!!!";

    public LottoTicket purchaseTicket(OrderPrice lottoPrice, List<String> manualNumbers) {

        int manualTicketCount = manualNumbers.size();
        int autoTicketCount = lottoPrice.getLottoPrice() / LOTTO_PRICE - manualTicketCount;

        if(manualTicketCount * LOTTO_PRICE > lottoPrice.getLottoPrice()) {
            throw new IllegalArgumentException(MANUAL_ERROR_MSG);
        }

        return new LottoTicket(autoTicketCount, manualNumbers);
    }

}
