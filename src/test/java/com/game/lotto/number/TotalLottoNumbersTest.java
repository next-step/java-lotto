package com.game.lotto.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.game.lotto.number.LottoNumber.MAX_VALUE_OF_LOTTO_NUMBER;
import static com.game.lotto.number.LottoNumber.MIN_VALUE_OF_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TotalLottoNumbersTest {

    @Test
    void get_total_numbers_of_lotto_ticket() {
        List<LottoNumber> totalNumbersOfLottoTicket = TotalLottoNumbers.getTotalNumbersOfLottoTicket();
        for (LottoNumber number : totalNumbersOfLottoTicket) {
            assertThat(number.getNumber()).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number.getNumber()).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
        assertEquals(MAX_VALUE_OF_LOTTO_NUMBER, totalNumbersOfLottoTicket.size());
    }
}