package com.game.lotto.count;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketCountTest {

    private final static int TICKET_COUNT = 3;

    @Test
    void get_count() {
        TicketCount ticketCount = new TicketCount(TICKET_COUNT);
        assertEquals(TICKET_COUNT, ticketCount.getCount());
    }
}