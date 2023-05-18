package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachineTest {
    @Test
    void 로또구매개수확인() {
        LottoMachine lottoMachine = new LottoMachine();

        List<LottoTicket> lotteTickets = lottoMachine.buyLottoTickets(14000);

        Assertions.assertThat(lotteTickets.size()).isEqualTo(14);
    }

    @Test
    void 수동구매시로또구매개수확인() {
        LottoMachine lottoMachine = new LottoMachine();

        List<LottoTicket> manualTickets = new ArrayList<>();
        manualTickets.add(LottoTicket.createLottoTicketByManual(
                new ArrayList<Integer>(Arrays.asList(1, 5, 6, 30, 35, 45))));

        List<LottoTicket> lotteTickets = lottoMachine.buyLottoTickets(new Money(10000), manualTickets);

        Assertions.assertThat(lotteTickets.size()).isEqualTo(10);
    }
}
