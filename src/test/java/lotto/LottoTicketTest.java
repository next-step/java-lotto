package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void validateLottoTicketTest() {
        LottoTicket lottoTicket = new LottoTicket();
        for (int number : lottoTicket.getLottoTicket()) {
            assertThat(number).isBetween(1, 45);
        }
    }

}
