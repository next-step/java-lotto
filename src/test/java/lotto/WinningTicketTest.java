package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningTicketTest {
    @Test
    void 보너스볼_생성() {
        WinningTicket winningTicket = new WinningTicket(new String[]{"1", "2", "3", "4", "5", "6"}, "7");
        assertThat(winningTicket.getBonusNumber()).isEqualTo(LottoNumber.of(7));
    }

    @Test
    void 잘못된_보너스볼_생성() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningTicket(new String[]{"1", "2", "3", "4", "5", "6"}, "3"));
    }
}
