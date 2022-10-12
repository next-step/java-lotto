package com.game.lotto.ticket;

public class TicketCount {
    private final int count;

    public TicketCount(int inputPrice) {
        this.count = inputPrice / MyTicket.PRICE_OF_TICKET_UNIT;
    }

    public int getCount() {
        return count;
    }
}
