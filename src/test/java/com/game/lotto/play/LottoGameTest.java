package com.game.lotto.play;

import com.game.lotto.money.Money;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.ticket.WinnerTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private static final Money INPUT_PRICE = new Money(14000);
    private static final List<LottoNumber> WINNER_LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    private static final LottoNumber BONUS_NUMBER = new LottoNumber(7);

    @Test
    void compare_with_winner_ticket_and_get_earning_rates() {
        LottoGame lottoGame = new LottoGame(INPUT_PRICE);
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(WINNER_LOTTO_NUMBERS), BONUS_NUMBER);
        double earningRates = lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket);
        assertThat(earningRates).isGreaterThanOrEqualTo(0.00);
    }
}