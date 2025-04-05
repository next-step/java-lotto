package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("수동 로또 티켓 테스트")
    void manualLottoTest() {
        LottoTicket lottoTicket = new LottoTicket(true);
        assertThat(lottoTicket.isManual()).isTrue();
    }

    @Test
    void autoLottoTest() {
        LottoTicket lottoTicket = new LottoTicket(false);
        assertThat(lottoTicket.isManual()).isFalse();
    }
}
