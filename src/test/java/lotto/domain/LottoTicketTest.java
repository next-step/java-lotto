package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓의 사이즈는 입력받은 값과 일치해야한다.")
    void create() {
        LottoTicket lottoTicket = new LottoTicket(14);
        Assertions.assertThat(lottoTicket.getLottoTicket()).hasSize(14);
    }
}
