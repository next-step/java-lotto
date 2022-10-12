package com.game.lotto.play;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ticket.WinnerTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private final static int INPUT_PRICE = 14000;
    private final static int BONUS_NUMBER = 7;

    private final List<Integer> winnerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void compare_with_winner_ticket_and_get_earning_rates() {
        LottoGame lottoGame = new LottoGame(INPUT_PRICE, new RandomLottoNumberGenerator());
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(winnerLottoNumbers), BONUS_NUMBER);
        double earningRates = lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket);
        assertThat(earningRates).isGreaterThanOrEqualTo(0.00);
    }
}