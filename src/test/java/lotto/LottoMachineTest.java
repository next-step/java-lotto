package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("입력한 수량만큼 로또티켓을 생성한다.")
    @Test
    void issueLottoTickets() {
        //given
        int ticketCount = 3;
        LottoMachine lottoMachine = new LottoMachine(ticketCount);

        //when
        List<LottoTicket> lottoTickets = lottoMachine.issueTickets();

        //then
        assertThat(lottoTickets).hasSize(ticketCount);
    }
}
