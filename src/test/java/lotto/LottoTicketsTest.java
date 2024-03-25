package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoTickets;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "3500,3", "1000,1"})
    void 로또티켓생성(String amount, int expected) {
        LottoTickets lottoTickets = new LottoTickets(new Amount(amount), Collections.emptyList());
        assertThat(lottoTickets.size()).isEqualTo(expected);
    }
}
