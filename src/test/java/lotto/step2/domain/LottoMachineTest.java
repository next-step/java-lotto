package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    @DisplayName("자동으로 로또 여러장 발급하기.")
    void autoIssueLotto() {
        LottoTickets actualLottoTickets = LottoMachine.autoIssueLottoTickets(() -> LottoTicketsTest.LOTTO_TICKETS);
        assertThat(actualLottoTickets).isEqualTo(LottoTicketsTest.LOTTO_TICKETS);
    }
}
