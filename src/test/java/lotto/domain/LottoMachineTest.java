package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 머신에서 번호 생성 테스트")
    void generate_lotto_numbers_test() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoNumber();

        // when & then
        assertThat(lottoTicket.getLottoTicketNumbers().size()).isEqualTo(6);
    }
}
