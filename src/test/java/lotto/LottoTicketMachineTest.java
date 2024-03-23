package lotto;

import lotto.domain.IssuedLottoTickets;
import lotto.domain.LottoTicketMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("[성공] 구입 금액만큼의 로또를 발권한다.")
    void 로또_발권() {
        IssuedLottoTickets lottoTickets = LottoTicketMachine.issue(14000, Collections.emptyList());
        assertThat(lottoTickets.manualLottoTicketsSize() + lottoTickets.autoLottoTicketsSize()).isEqualTo(14);
    }
}
