package com.game.lotto.rate;

import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ticket.MyTickets;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.TicketsByStrikes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRatesTest {

    private static final long TOTAL_AMOUNT_OF_TICKET_MONEY = 14_000;
    private MyTickets myTickets;
    private TicketsByStrikes ticketsByStrikes;
    private EarningRates earningRates;

    @BeforeEach
    void set_up() {
        myTickets = new MyTickets(TOTAL_AMOUNT_OF_TICKET_MONEY / Ticket.PRICE_OF_TICKET_UNIT, new RandomLottoNumberGenerator());
    }

    @Test
    void calculate_earning_rates_by_random_winner_number() {
        Ticket winnerTicket = new Ticket(new RandomLottoNumberGenerator());
        ticketsByStrikes = new TicketsByStrikes(winnerTicket, myTickets.getTickets());
        earningRates = new EarningRates(TOTAL_AMOUNT_OF_TICKET_MONEY, ticketsByStrikes);
        double result = earningRates.calculateEarningRatesAndPrintResults();
        assertThat(result).isGreaterThanOrEqualTo(0.00);
    }
}