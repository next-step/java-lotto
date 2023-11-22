package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    @DisplayName("로또 머신은 로또티켓을 만들 수 있다.")
    void generateLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(3);
        Assertions.assertThat(lottoTicket.getLottoTicket()).hasSize(3);
    }
}
