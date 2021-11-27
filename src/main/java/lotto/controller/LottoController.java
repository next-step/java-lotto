package lotto.controller;

import lotto.domain.AllAutomaticLottoTicketStrategy;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.value.LottoTickets;
import lotto.domain.value.Price;
import lotto.utils.InputUtils;

public class LottoController {

    private final LottoTicketGenerator ticketGenerator;

    public LottoController(LottoTicketGenerator ticketGenerator) {
        this.ticketGenerator = ticketGenerator;
    }

    public LottoTickets createLottoTickets(String purchaseAmount) {
        Price price = InputUtils.createPrice(purchaseAmount);

        return ticketGenerator.generateTickets(price, new AllAutomaticLottoTicketStrategy());
    }


}
