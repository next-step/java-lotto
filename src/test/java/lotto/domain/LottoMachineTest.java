package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void name() {
        LottoMachine machine = new LottoMachine(new LottoGenerator(Collections::shuffle));
        LottoTicket ticket = machine.buyTicket(15000);

        assertThat(ticket.getLottos())
                .hasSize(15);
    }
}
