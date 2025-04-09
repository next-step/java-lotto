package lotto.domain.service;

import lotto.domain.generator.StaticLottoTicketGenerator;
import lotto.domain.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("구입 금액에 따라 로또를 구매한다.")
    @Test
    void buyTest() {
        LottoMachine lottoMachine = new LottoMachine(new StaticLottoTicketGenerator(List.of(1, 2, 3, 4, 5, 6)), 2000);

        List<LottoTicket> lottoTickets = lottoMachine.buyAutomaticLottos();
        assertThat(lottoTickets.size()).isEqualTo(2);
    }
}
