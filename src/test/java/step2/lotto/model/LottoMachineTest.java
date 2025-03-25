package step2.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 발행 테스트")
    void givenLottoMachine_whenCreateLottoMachine_thenSuccess() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoTicket lottoTicket = lottoMachine.issueLottoTicket();

        // then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket.value().size()).isEqualTo(6);
        for (LottoNumber lottoNumber : lottoTicket.value()) {
            assertThat(lottoNumber.value()).isBetween(1, 45);
        }
    }

}
