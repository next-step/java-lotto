package com.game.lotto.ticket;

import com.game.lotto.count.TicketCount;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.prize.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketsByRanksTest {

    private static final TicketCount TOTAL_TICKET_COUNT = new TicketCount(14);
    private static final List<LottoNumber> WINNER_LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    private static final LottoNumber BONUS_NUMBER = new LottoNumber(7);
    private static final WinnerTicket WINNER_TICKET = new WinnerTicket(new ManualLottoNumberGenerator(WINNER_LOTTO_NUMBERS), BONUS_NUMBER);

    private MyTickets myTickets;
    private TicketsByRanks ticketsByRanks;

    @BeforeEach
    void set_up() {
        myTickets = new MyTickets();
        myTickets.addRandomTicketsByCount(TOTAL_TICKET_COUNT);
        ticketsByRanks = new TicketsByRanks(WINNER_TICKET, myTickets.getTickets());
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