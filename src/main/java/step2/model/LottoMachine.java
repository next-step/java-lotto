package step2.model;

import step2.exception.NotEnoughMoneyException;

public class LottoMachine {

    private static final int TICKET_INITIAL_COUNT = 0;

    private final LottoTicketPrice ticketPrice;

    private LottoMachine(LottoTicketPrice ticketPrice) {
        if (ticketPrice == null) {
            throw new IllegalArgumentException("티켓 금액을 설정해주세요.");
        }

        this.ticketPrice = ticketPrice;
    }

    public static LottoMachine create(LottoTicketPrice ticketPrice) {
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
