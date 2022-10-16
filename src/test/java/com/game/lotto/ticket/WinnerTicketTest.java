package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.RandomLottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.game.lotto.number.LottoNumber.MAX_VALUE_OF_LOTTO_NUMBER;
import static com.game.lotto.number.LottoNumber.MIN_VALUE_OF_LOTTO_NUMBER;
import static com.game.lotto.number.SelectedLottoNumbers.LOTTO_NUMBER_SELECT_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTicketTest {

    private final static LottoNumber BONUS_NUMBER = new LottoNumber(7);

    @Test
    void get_numbers() {
        WinnerTicket winnerTicket = new WinnerTicket(new RandomLottoNumberGenerator(), BONUS_NUMBER);
        List<LottoNumber> winnerTicketSelectedNumbers = winnerTicket.getNumbers().getSelectedNumbers();
        for (LottoNumber number : winnerTicketSelectedNumbers) {
            assertThat(number.getNumber()).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number.getNumber()).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
        assertEquals(LOTTO_NUMBER_SELECT_COUNT, winnerTicketSelectedNumbers.size());

    }

    @Test
    void get_bonus_number() {
        WinnerTicket winnerTicket = new WinnerTicket(new RandomLottoNumberGenerator(), new LottoNumber(7));
        assertEquals(BONUS_NUMBER, winnerTicket.getBonusNumber());
    }
}