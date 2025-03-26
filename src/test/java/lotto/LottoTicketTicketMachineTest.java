package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTicketMachineTest {

    @Test
    @DisplayName("로또 발행한다.")
    void lottoIssueTest() {
        var machine = new LottoTicketMachine();
        var lotto = machine.issue();

        Assertions.assertThat(lotto).isInstanceOf(LottoTicket.class);
    }
}
