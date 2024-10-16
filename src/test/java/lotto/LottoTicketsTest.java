package lotto;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 개수 확인")
    void lottoTicketCount() {
        int price = 3000;
        LottoTickets lottoTickets = new LottoTickets(price);

        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}
