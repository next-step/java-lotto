package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("구입한 로또의 개수만큼 입력하면 로또의 개수는 그만큼 만들어진다.")
    void inputLottoTicketCountTest() {
        LottoTickets lottoTickets = new LottoTickets(5);

        assertThat(lottoTickets.getTickets()).hasSize(5);
    }
}
