package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("한 장의 로또티켓 무작위 6자리 수를 반환한다.")
    void 로또_번호를_발급한다() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.makeLottoTicket().size()).isEqualTo(6);
    }
}
