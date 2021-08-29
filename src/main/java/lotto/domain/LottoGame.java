package lotto.domain;

import lotto.generic.Money;

public class LottoGame {

    public static LottoTickets buy(final Money money, final String[] inputManualLottoTickets) {
        TicketCount autoTicketCount = TicketCount.calculateTicketCount(money)
                .minus(new TicketCount(inputManualLottoTickets.length));
        return LottoTickets.init(inputManualLottoTickets, autoTicketCount);
    }
}
