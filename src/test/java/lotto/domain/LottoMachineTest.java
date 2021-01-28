package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    static LottoMachine lottoMachine;

    @BeforeAll
    static void initAll () {
        lottoMachine = new LottoMachine();
    }

    @Test
    void getLottoTicketNumberTest () {
        Assertions.assertThat(lottoMachine.getLottoTicketNumber(14000)).isEqualTo(14);
    }
}
