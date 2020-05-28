package step2.controller;

import step2.exception.NotEnoughMoneyException;
import step2.model.LottoTicketGenerator;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;

public class LottoMachine {

    private static final int TICKET_INITIAL_COUNT = 0;

    private final LottoTicketPrice ticketPrice;

    private LottoMachine(LottoTicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public static LottoMachine newInstance() {
        return new LottoMachine(LottoTicketPrice.getDefault());
    }

    public static LottoMachine newInstance(LottoTicketPrice ticketPrice) {
        return new LottoMachine(ticketPrice);
    }

    public LottoTickets buyTicket(Money money) {
        validateMoney(money);

        int buyTicketCount = TICKET_INITIAL_COUNT;

        while (money.isAvailableAmount(ticketPrice)) {
            money.useAmount(ticketPrice);
            buyTicketCount++;
        }

        return LottoTicketGenerator.generate(buyTicketCount);
    }

    private void validateMoney(Money money) {
        if (!money.isAvailableAmount(ticketPrice)) {
            throw new NotEnoughMoneyException();
        }
    }
}
