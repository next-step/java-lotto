package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("한 장의 로또티켓 무작위 6자리 수를 반환")
    void 로또_번호를_발급() {
        assertThat(lottoMachine.makeLottoTicket().getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("금액만큼 로또 장 수 확인")
    void 금액만큼_로또_번호를_발급() {
        assertThat(lottoMachine.makeTotalLottoTickets(14).size()).isEqualTo(14);
    }

    @Test
    @DisplayName("수익률을 확인")
    void 수익률_확인() {
        assertThat(0.35).isEqualTo(lottoMachine.rateOfReturnResult(14000, 5000));
    }
}
