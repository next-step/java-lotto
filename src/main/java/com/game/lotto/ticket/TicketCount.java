package com.game.lotto.ticket;

public class TicketCount {
    private int count;

    public TicketCount(int inputPrice) {
        this.count = inputPrice / MyTicket.PRICE_OF_TICKET_UNIT;
    }

    public boolean hasNext() {
        return count > 0;
    }

    public void next() {
        count--;
    }
}
