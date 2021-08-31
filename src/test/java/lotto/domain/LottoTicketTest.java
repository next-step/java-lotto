package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("입력한 티켓수의 티켓이 생성된다.")
    @Test
    void size_test() {
        LottoTicket lottoTicket = new LottoTicket(1, new LottoNumberRandomSelector());
        assertThat(lottoTicket.size()).isEqualTo(1);
    }

}
