package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    @DisplayName("입력받은 숫자와 로또 티켓의 사이즈는 같아야한다.")
    void size() {
        LottoTicket lottoTicket = new LottoTicket(3);
        Assertions.assertThat(lottoTicket.getLottoTicket()).hasSize(3);
    }
}
