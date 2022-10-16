package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.prize.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.game.lotto.number.SelectedLottoNumbers.LOTTO_NUMBER_SELECT_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class MyTicketTest {

    private static final List<LottoNumber> LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    private static final List<LottoNumber> WINNER_LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    private static final LottoNumber BONUS_NUMBER = new LottoNumber(7);

    private MyTicket randomMyTicket;
    private MyTicket manualMyTicket;

    @BeforeEach
    void set_up() {
        randomMyTicket = new MyTicket(new RandomLottoNumberGenerator());
        manualMyTicket = new MyTicket(new ManualLottoNumberGenerator(LOTTO_NUMBERS));
    }

    @Test
    void get_ticket_strikes_by_random_numbers() {
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(WINNER_LOTTO_NUMBERS), BONUS_NUMBER);
        Rank rank = randomMyTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
        assertThat(rank.getStrikes().getCount()).isGreaterThanOrEqualTo(0);
        assertThat(rank.getStrikes().getCount()).isLessThanOrEqualTo(LOTTO_NUMBER_SELECT_COUNT);
    }

    @Test
    void get_ticket_strikes_by_manual_numbers() {
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(WINNER_LOTTO_NUMBERS), BONUS_NUMBER);
        Rank rank = manualMyTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
        assertThat(rank.getStrikes().getCount()).isEqualTo(LOTTO_NUMBER_SELECT_COUNT);
    }
}