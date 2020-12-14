package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketCountTest {

    @Test
    @DisplayName("구매한 로또 티켓 갯수 확인")
    void lotto_ticket_count_test() {
        // given
        int money = 14000;

        // when
        LottoTicketCount lottoTicketCount = LottoTicketCount.getInstance(money);

       // then
        assertThat(lottoTicketCount.getLottoTicketCount()).isEqualTo(14);
    }

}
