package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또 번호 생성 테스트")
    void winning_lotto_number_test() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        WinningLotto winningLotto = WinningLotto.ofLottoNumbers(LottoMachine.createManualLottoNumbers(StringSplitter.splitText(numbers)));

        // then
        assertThat(winningLotto.getWinningLottoTicket().getLottoTicketNumbers().size()).isEqualTo(6);
        assertThat(winningLotto.getWinningLottoTicket().getLottoTicketNumbers())
                .containsExactly(LottoNumber.ofNumber(1), LottoNumber.ofNumber(2), LottoNumber.ofNumber(3), LottoNumber.ofNumber(4), LottoNumber.ofNumber(5), LottoNumber.ofNumber(6));
    }

}
