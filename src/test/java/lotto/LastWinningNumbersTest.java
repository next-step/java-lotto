package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LastWinningNumbersTest {

    @DisplayName(value = "당첨번호가 몇개인지 테스트")
    @Test
    void sumCountOfMatch() {
        // when
        LottoTicket lottoTicket = LottoTicket.newTicket(Arrays.asList(Number.newNumber(1),
                                                                        Number.newNumber(2),
                                                                        Number.newNumber(3),
                                                                        Number.newNumber(4),
                                                                        Number.newNumber(5),
                                                                        Number.newNumber(6)));

        LottoTicket winningLottoTicket = LottoTicket.newTicket(Arrays.asList(Number.newNumber(1),
                                                                                Number.newNumber(2),
                                                                                Number.newNumber(3),
                                                                                Number.newNumber(4),
                                                                                Number.newNumber(5),
                                                                                Number.newNumber(6)));

        LastWinningNumbers winningNumbers = LastWinningNumbers.newWinningNumbers(winningLottoTicket, Number.newNumber(7));

        // when
        int countOfMatch = winningNumbers.sumCountOfMatch(lottoTicket.getTicket());

        // then
        Assertions.assertThat(countOfMatch).isEqualTo(6);
    }
}