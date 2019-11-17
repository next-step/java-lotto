package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoTicket;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket lottoTicket = new LottoTicket();

    @DisplayName("자동 로또 숫자 6개 생성")
    @Test
    void makeAutoNumbersTest() {
        assertThat(lottoTicket.size()).isEqualTo(6);
    }
}
