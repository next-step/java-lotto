package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerNumbersTest {

    @Test
    void assertMatchForPrize() {
        List<Integer> lottoNumbersForTest = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbersForTest);
        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbersForTest);

        assertThat(winnerNumbers.calculateTotalMatchedCount(lottoTicket)).isEqualTo(6);
    }

}