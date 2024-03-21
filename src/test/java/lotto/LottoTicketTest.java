package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Test
    void 로또숫자가_중복되지_않는지() {
        LottoTicket lottoTicket = new LottoTicket();
        int distinctSize = (int) lottoTicket.getNumbers()
                .stream()
                .distinct()
                .count();
        assertThat(distinctSize).isEqualTo(LOTTO_NUMBER_COUNT);
    }


    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:3",
                        "1, 3, 5, 7, 8, 10:4",
                        "1, 3, 5, 7, 9, 10:5",
                        "1, 3, 5, 7, 9, 11:6"}, delimiter = ':')
    void 당첨숫자와_일치하는_숫자개수(String input, int expected) {
        LottoTicket lottoTicket = new LottoTicket(1, 3, 5, 7, 9, 11);
        WinningNumbers winningNumbers = new WinningNumbers(input, ", ");
        assertThat(lottoTicket.getMatchCount(winningNumbers)).isEqualTo(expected);
    }

}
