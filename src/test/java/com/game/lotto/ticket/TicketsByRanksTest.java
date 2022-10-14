package com.game.lotto.ticket;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.prize.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketsByRanksTest {

    private static final int TOTAL_AMOUNT_OF_TICKET_MONEY = 14_000;

    private final MyTickets myTickets = new MyTickets(new TicketCount(TOTAL_AMOUNT_OF_TICKET_MONEY), new RandomLottoNumberGenerator());
    private final WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(List.of(1, 2, 3, 4, 5, 6)), 7);
    private TicketsByRanks ticketsByRanks;

    @BeforeEach
    void set_up() {
        ticketsByRanks = new TicketsByRanks(winnerTicket, myTickets.getTickets());
    }

    @Test
    void get_strikes_by_numbers() {
        int totalTicketCount = 0;
        for (Rank rank : Rank.values()) {
            int strikeTicketCount = ticketsByRanks.getTicketsByRank(rank).size();
            System.out.println("rank " + rank.name() + " => " + strikeTicketCount);
            assertThat(strikeTicketCount).isGreaterThanOrEqualTo(0);
            assertThat(strikeTicketCount).isLessThanOrEqualTo(myTickets.getTickets().size());
            totalTicketCount += strikeTicketCount;
        }
        assertThat(totalTicketCount).isEqualTo(myTickets.getTickets().size());
    }
}