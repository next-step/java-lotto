package lotto.domain.result;

import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.support.LottoNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningTicketTest {

    @DisplayName("LottoTicket의 숫자와 보너스숫자가 중복되면 익셉션을 던진다")
    @Test
    void generate() {
        LottoTicket winningLottoTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber bonusNumber = LottoNumber.of(6);

        assertThatThrownBy(() -> new WinningTicket(winningLottoTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스번호와 당첨번호는 중복될 수 없습니다");
    }


}
