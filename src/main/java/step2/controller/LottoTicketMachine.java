package step2.controller;

import step2.model.LottoTicketGenerator;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;

public class LottoTicketMachine {

    private final LottoTicketPrice ticketPrice;

    private LottoTicketMachine(LottoTicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public static LottoTicketMachine newInstance(LottoTicketPrice ticketPrice) {
        return new LottoTicketMachine(ticketPrice);
    }

    public LottoTickets buy(Money money) {
        int buyTicketCount = 0;

        while (money.isAvailableAmount(ticketPrice.getPrice())) {
            money.useAmount(ticketPrice.getPrice());
            buyTicketCount++;
        }

        return LottoTicketGenerator.generate(buyTicketCount);
    }
}
