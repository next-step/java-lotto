package lotto;

import lotto.domain.IssuedLottoTickets;
import lotto.domain.LottoTicketMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("[성공] 구입 금액만큼의 로또를 발권한다.")
    void 로또_발권() {
        IssuedLottoTickets issuedLottoTickets = LottoTicketMachine.issue(14000, Collections.emptyList());
        assertThat(issuedLottoTickets.manualSize() + issuedLottoTickets.autoSize()).isEqualTo(14);
    }

    @Test
    @DisplayName("[성공] 수동 로또 2개와 자동 로또 3개를 발권한다.")
    void 로또_발권_자동_수동() {
        IssuedLottoTickets issuedLottoTickets = LottoTicketMachine.issue(5000, List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(41, 42, 43, 44, 45)
        ));
        assertThat(issuedLottoTickets.manualSize()).isEqualTo(2);
        assertThat(issuedLottoTickets.autoSize()).isEqualTo(3);
    }

}
