package com.game.lotto.play;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.ticket.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    private final static long INPUT_PRICE = 14000;
    private final String[] winnerLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};
    private LottoGame lottoGame;

    @BeforeEach
    void set_up() {
        lottoGame = new LottoGame();
    }

    @Test
    void buy_tickets() {
        long ticketCount = lottoGame.buyTickets(INPUT_PRICE);
        assertEquals(INPUT_PRICE / Ticket.PRICE_OF_TICKET_UNIT, ticketCount);
    }

    @Test
    void compare_with_winner_ticket_and_get_earning_rates() {
        lottoGame.buyTickets(INPUT_PRICE);
        Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(winnerLottoNumbers));
        double earningRates = lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket, INPUT_PRICE);
        assertThat(earningRates).isGreaterThanOrEqualTo(0.00);
    }
}