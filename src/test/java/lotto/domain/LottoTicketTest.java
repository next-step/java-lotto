package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 랜덤한 숫자 6개를 반환한다.")
    void createRandomNumbers() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.issue()).hasSize(6);
    }
}