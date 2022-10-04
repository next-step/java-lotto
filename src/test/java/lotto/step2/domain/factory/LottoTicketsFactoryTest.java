package lotto.step2.domain.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.LottoTicketsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsFactoryTest {
    @Test
    @DisplayName("자동으로 로또 발급하기.")
    void autoIssueLotto() {
        LottoTickets actualLottoTickets = LottoTicketsFactory.from(() -> LottoTicketsTest.LOTTO_TICKETS);
        assertThat(actualLottoTickets).isEqualTo(LottoTicketsTest.LOTTO_TICKETS);
    }
}