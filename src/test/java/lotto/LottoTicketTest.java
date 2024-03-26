package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("WinningCount를 통한 로또 번호 3개 당첨 테스트")
    void WinningCount_3개_당첨() {
        assertThat(WinningCount.compareNumbers(Arrays.asList(1,2,3,4,5,6), Arrays.asList(4,5,6,7,8,9))).isEqualTo(3);
    }

    @Test
    @DisplayName("lottoTicket을 통한 로또 번호 4개 당첨 테스트")
    void lotto_4개_당첨() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoTicket.winningCount(Arrays.asList(3,4,5,6,7,8))).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 당첨 확률 테스트(500%)")
    void lotto_당첨_확률() {
        /**
         * TODO:: 더 좋은 방향으로 테스트할수 있을것같은데 고민필요
         */
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1,2,3,4,5,6))));
        assertThat(lottoTickets.profitRate(lottoTickets.winningCheck(Arrays.asList(1,2,3,7,8,9)))).isEqualTo(5.0);
    }
}
