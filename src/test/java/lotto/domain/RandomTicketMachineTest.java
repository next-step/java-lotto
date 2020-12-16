package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTicketMachineTest {

    @DisplayName("요청 숫자만큼 티켓 발행")
    @Test
    void issueTicket() {
        //given
        int ticketCount = 3;
        RandomTicketMachine randomTicketMachine = new RandomTicketMachine();

        //when
        List<LottoTicket> lottoTickets = randomTicketMachine.issue(ticketCount);

        //then
        assertThat(lottoTickets.size()).isEqualTo(ticketCount);
    }
}
