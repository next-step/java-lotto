package Lotto.Ticket;

import Lotto.Number.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketTest {

    @DisplayName("로또 티켓은 6개의 랜덤 넘버로 초기화된다.")
    @Test
    void createLottoTicket() {
        assertDoesNotThrow(() -> new LottoTicket(new RandomNumbers(6, 1, 45).getValue()));
    }
}
