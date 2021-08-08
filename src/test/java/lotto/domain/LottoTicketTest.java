package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @DisplayName("로또 티켓 생성 성공")
    @Test
    void create() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void validate() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinAmount() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(lottoTicket.getWinAmount(winLotto)).isEqualTo(WinAmount.FIRST);
    }
}