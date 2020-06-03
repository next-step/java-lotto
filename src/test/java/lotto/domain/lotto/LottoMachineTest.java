package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 로또티켓을_구매한다() {
        int quantity = 5;
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoTicket = lottoMachine.purchaseLotto(quantity);

        assertThat(lottoTicket).size().isEqualTo(quantity);

    }

}