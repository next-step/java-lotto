package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    private LottoTicket lottoTicket;
    private LottoTicket winningLottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9));
    }

    @Test
    @DisplayName("lottoTicket을 통한 로또 번호 3개 당첨 테스트")
    void lotto_3개_당첨() {
        assertThat(lottoTicket.winningCount(winningLottoTicket)).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 당첨 확률 테스트(500%)")
    void lotto_당첨_확률() {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket));
        assertThat(lottoTickets.winningCheck(winningLottoTicket).profitRate()).isEqualTo(5.0);
    }
}
