package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoMachineTest {
    @Test
    void 로또구매개수확인() {
        LottoMachine lottoMachine = new LottoMachine();

        List<LottoTicket> lotteTickets = lottoMachine.buyLottoTickets(14000);

        Assertions.assertThat(lotteTickets.size()).isEqualTo(14);

    }
}
