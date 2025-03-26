package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("로또 발행한다.")
    void lottoIssueTest() {
        var lotto = LottoTicketMachine.issue();

        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
