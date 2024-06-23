package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketBundleTest {
    @Test
    @DisplayName("구입금액을 입력하면 구입할 수 있을 만큼 자동 로또 티켓이 구매된다.")
    void test1() {
        LottoTicketBundle lottoTickets = LottoTicketBundle.create(14000);
        assertThat(lottoTickets.getLottoTickets()).hasSize(14);
    }
}