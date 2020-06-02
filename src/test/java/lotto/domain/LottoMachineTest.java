package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 로또티켓을_구매한다() {
        int purchaseAmount = 5000;
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoTicket = lottoMachine.purchaseLotto(purchaseAmount);

        assertThat(lottoTicket).size().isEqualTo(purchaseAmount / 1000);
    }

}