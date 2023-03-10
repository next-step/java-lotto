package lotto.domain.strategy;

import lotto.domain.LottoTickets;

public class AutoCreationStrategy extends LottoCreationStrategy {

    private final int price;

    public AutoCreationStrategy(final int price) {
        this.price = price;
    }

    @Override
    public LottoTickets createLottoTickets() {
        int numberOfTicket = calculateLottoTicketCount(price);
        return LottoTickets.of(numberOfTicket);
    }
}
