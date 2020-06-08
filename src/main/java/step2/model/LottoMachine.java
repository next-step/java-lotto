package step2.model;

import step2.exception.NotEnoughMoneyException;

public class LottoMachine {

    private static final int MIN_TICKET_COUNT = 1;

    private final LottoTicketPrice ticketPrice;

    private LottoMachine(LottoTicketPrice ticketPrice) {
        if (ticketPrice == null) {
            throw new IllegalArgumentException("티켓 금액을 입력해주세요.");
        }

        this.ticketPrice = ticketPrice;
    }

    public static LottoMachine create(LottoTicketPrice ticketPrice) {
        return new LottoMachine(ticketPrice);
    }

    public LottoTicket buyTicket(MoneyAmount moneyAmount) {
        int ticketCount = ticketPrice.getAvailablePurchase(moneyAmount);

        if (ticketCount < MIN_TICKET_COUNT) {
            throw new NotEnoughMoneyException();
        }

        moneyAmount.useAmount(ticketPrice.calculatePurchaseAmount(ticketCount));

        return LottoTicketGenerator.generate(ticketCount);
    }
}
