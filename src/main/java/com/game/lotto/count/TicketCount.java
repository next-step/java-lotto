package com.game.lotto.count;

import com.game.lotto.money.Money;
import com.game.lotto.ticket.MyTicket;

public class TicketCount {
    private final int count;

    public TicketCount(int count) {
        this.count = count;
    }

    public TicketCount(Money inputPrice) {
        this(inputPrice.getAmount() / MyTicket.PRICE_OF_TICKET_UNIT);
    }

    public int getCount() {
        return count;
    }
}
