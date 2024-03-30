package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinnerPrize;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningTicketTest {
    @Test
    void 보너스볼_생성() {
        WinningTicket winningTicket = new WinningTicket(new String[]{"1", "2", "3", "4", "5", "6"}, "7");
        assertThat(winningTicket).isNotNull();
    }

    @Test
    void 잘못된_보너스볼_생성() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningTicket(new String[]{"1", "2", "3", "4", "5", "6"}, "3"));
    }

    @Test
    void 등수_계산() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(new String[]{"1", "2", "3", "4", "5", "7"}, "6");
        assertThat(winningTicket.rank(lottoTicket)).isEqualTo(WinnerPrize.SECOND);
    }
}
