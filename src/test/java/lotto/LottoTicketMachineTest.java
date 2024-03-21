package lotto;

import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("[성공] 구입 금액만큼의 로또를 발권한다.")
    void 로또_발권() {
        LottoTickets lottoTickets = LottoTicketMachine.issue(14000);
        assertThat(lottoTickets.size()).isEqualTo(14);
    }
}
