package step2.controller;

import step2.exception.NotEnoughMoneyException;
import step2.model.LottoTicketGenerator;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;

public class LottoTicketMachine {

    private static final int TICKET_INITIAL_COUNT = 0;

    private final LottoTicketPrice ticketPrice;

    private LottoTicketMachine(LottoTicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public static LottoTicketMachine newInstance() {
        return new LottoTicketMachine(LottoTicketPrice.getDefault());
    }

    public static LottoTicketMachine newInstance(LottoTicketPrice ticketPrice) {
        return new LottoTicketMachine(ticketPrice);
    }

    public LottoTickets buy(Money money) {
        int buyTicketCount = TICKET_INITIAL_COUNT;

        while (money.isAvailableAmount(ticketPrice)) {
            money.useAmount(ticketPrice);
            buyTicketCount++;
        }

        if (buyTicketCount == TICKET_INITIAL_COUNT) {
            throw new NotEnoughMoneyException();
        }

        return LottoTicketGenerator.generate(buyTicketCount);
    }
}
