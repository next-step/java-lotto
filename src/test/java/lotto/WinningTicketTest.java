package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerPrize;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTicketTest {
    @Test
    void 등수_계산() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        WinningTicket winningTicket = new WinningTicket(new LottoTicket("1", "2", "3", "4", "5", "7"), LottoNumber.of("6"));
        assertThat(winningTicket.rank(lottoTicket)).isEqualTo(WinnerPrize.SECOND);
    }
}
