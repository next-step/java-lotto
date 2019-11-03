package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket lottoTicket = new LottoTicket();
    @Test
    void makeAutoNumbersTest() {
        assertThat(lottoTicket.makeAutoNumbers()).hasSize(6);
    }
}
