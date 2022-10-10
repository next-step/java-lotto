package com.game.lotto.ticket;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.game.lotto.number.LottoNumberGenerator.LOTTO_NUMBER_SELECT_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketsByStrikesTest {

    private static final long TRY_COUNT = 14;

    private final MyTickets myTickets = new MyTickets(TRY_COUNT, new RandomLottoNumberGenerator());
    private final Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));
    private TicketsByStrikes ticketsByStrikes;

    @BeforeEach
    void set_up() {
        ticketsByStrikes = new TicketsByStrikes(winnerTicket, myTickets.getTickets());
    }

    @Test
    void get_strikes_by_numbers() {
        int totalTicketCount = 0;
        for (int index = 0; index < LOTTO_NUMBER_SELECT_COUNT; index++) {
            int strikeTicketCount = ticketsByStrikes.getTicketsByStrikes(index).size();
            System.out.println("strikes " + index + " => " + strikeTicketCount);
            assertThat(strikeTicketCount).isGreaterThanOrEqualTo(0);
            assertThat(strikeTicketCount).isLessThanOrEqualTo((int) TRY_COUNT);
            totalTicketCount += strikeTicketCount;
        }
        assertThat(totalTicketCount).isEqualTo(TRY_COUNT);
    }
}