package com.game.lotto.play;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private final static long INPUT_PRICE = 14000;
    private final List<Integer> winnerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    private LottoGame lottoGame;

    @Test
    void compare_with_winner_ticket_and_get_earning_rates() {
        lottoGame = new LottoGame(INPUT_PRICE, new RandomLottoNumberGenerator());
        Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(winnerLottoNumbers));
        double earningRates = lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket);
        assertThat(earningRates).isGreaterThanOrEqualTo(0.00);
    }
}