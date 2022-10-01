package com.game.lotto.ticket;

import com.game.lotto.number.RandomLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.game.lotto.number.LottoNumberGenerator.LOTTO_NUMBER_SELECT_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class MyTicketsTest {

    private static final long TRY_COUNT = 14;
    private MyTickets myTickets;

    @BeforeEach
    void set_up() {
        myTickets = new MyTickets(TRY_COUNT);
    }

    @Test
    void get_strikes_by_random_winner_number() {
        Ticket winnerTicket = new Ticket(new RandomLottoNumberGenerator());
        myTickets.updateStrikesWithWinnerTicket(winnerTicket);
        int totalTicketCount = 0;
        for (int index = 0; index < LOTTO_NUMBER_SELECT_COUNT; index++) {
            int strikeTicketCount = myTickets.getTicketsByStrikes(index).size();
            assertThat(strikeTicketCount).isGreaterThanOrEqualTo(0);
            assertThat(strikeTicketCount).isLessThanOrEqualTo((int) TRY_COUNT);
            totalTicketCount += strikeTicketCount;
        }
        assertThat(totalTicketCount).isEqualTo(TRY_COUNT);
    }
}