package com.game.lotto.rate;

import com.game.lotto.count.TicketCount;
import com.game.lotto.money.Money;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ticket.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRatesTest {

    private static final TicketCount TICKET_COUNT = new TicketCount(14);
    private static final LottoNumber BONUS_NUMBER = new LottoNumber(7);
    private static final Money TOTAL_AMOUNT_OF_TICKET_MONEY = new Money(14_000);

    private MyTickets myTickets;

    @BeforeEach
    void set_up() {
        myTickets = new MyTickets();
        myTickets.addRandomTicketsByCount(TICKET_COUNT);
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