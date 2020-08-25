package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoMachine;
import step2.domain.LottoTicket;
import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {
    @Test
    void ticketTest() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.makeLotto("3000");

        assertThat(lottoTicket.getLottoNumberList().size()).isEqualTo(3);
    }
}
