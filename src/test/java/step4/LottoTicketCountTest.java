package step4;

import org.junit.jupiter.api.Test;
import step4.domain.LottoTicketCount;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketCountTest {
    LottoTicketCount lottoTicketCount = new LottoTicketCount(14000, 3);

    @Test
    void getManualLottoCount() {
        assertThat(lottoTicketCount.getManualLottoCount()).isEqualTo(3);
    }

    @Test
    void getAutoLottoCount() {
        assertThat(lottoTicketCount.getAutoLottoCount()).isEqualTo(11);
    }
}
