package com.game.lotto.ticket;

import com.game.lotto.count.TicketCount;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.SelectedLottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyTicketsTest {

    private static final List<LottoNumber> LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    private static final List<SelectedLottoNumbers> SELECTED_LOTTO_NUMBERS = List.of(new SelectedLottoNumbers(LOTTO_NUMBERS));
    private static final TicketCount TICKET_COUNT = new TicketCount(14);


    @Test
    void add_manual_tickets_and_get_count() {
        MyTickets myTickets = new MyTickets();
        myTickets.addManualTicketsByCount(SELECTED_LOTTO_NUMBERS);
        assertEquals(1, myTickets.getTickets().size());
    }

    @Test
    void add_random_tickets_and_get_count() {
        MyTickets myTickets = new MyTickets();
        myTickets.addRandomTicketsByCount(TICKET_COUNT);
        assertEquals(TICKET_COUNT.getCount(), myTickets.getTickets().size());
    }

}