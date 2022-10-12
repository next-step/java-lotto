package com.game.lotto.rate;

import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ticket.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRatesTest {

    private static final int TOTAL_AMOUNT_OF_TICKET_MONEY = 14_000;
    private final static int BONUS_NUMBER = 7;

    private MyTickets myTickets;

    @BeforeEach
    void set_up() {
        myTickets = new MyTickets(new TicketCount(TOTAL_AMOUNT_OF_TICKET_MONEY), new RandomLottoNumberGenerator());
    }

    @Test
    void calculate_earning_rates_by_random_winner_number() {
        WinnerTicket winnerTicket = new WinnerTicket(new RandomLottoNumberGenerator(), BONUS_NUMBER);
        TicketsByRanks ticketsByRanks = new TicketsByRanks(winnerTicket, myTickets.getTickets());
        EarningRates earningRates = new EarningRates(TOTAL_AMOUNT_OF_TICKET_MONEY, ticketsByRanks);
        double result = earningRates.calculateEarningRatesAndPrintResults();
        assertThat(result).isGreaterThanOrEqualTo(0.00);
    }
}