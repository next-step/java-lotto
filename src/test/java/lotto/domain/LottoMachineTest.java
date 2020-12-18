package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 머신에서 자동 로또 번호 생성 테스트")
    void generate_auto_lotto_ticket_test() {
        // given
        LottoMachine lottoMachine = LottoMachine.instance();

        // when
        LottoTicket lottoTicket = lottoMachine.generateAutoLottoNumber();

        // then
        assertThat(lottoTicket.getLottoTicketNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 머신에서 수동 로또 번호 생성 테스트")
    void generate_manual_lotto_ticket_test() {
        // given
        LottoMachine lottoMachine = LottoMachine.instance();
        LottoNumbers manualNumbers = new LottoNumbers(StringSplitter.splitText("1,2,3,4,5,6"));

        // when
        LottoTicket lottoTicket = lottoMachine.generateManualLottoNumbers(manualNumbers);

        // then
        assertThat(lottoTicket.getLottoTicketNumbers().size()).isEqualTo(6);
        assertThat(lottoTicket.getLottoTicketNumbers()).containsExactly(LottoNumber.ofNumber(1), LottoNumber.ofNumber(2),
                LottoNumber.ofNumber(3), LottoNumber.ofNumber(4), LottoNumber.ofNumber(5), LottoNumber.ofNumber(6));
    }

}
