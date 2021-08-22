package Lotto.Ticket;

import Lotto.Number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketTest {

    @DisplayName("로또 티켓은 6개의 숫자로 초기화된다.")
    @Test
    void createLottoTicket() {
        assertDoesNotThrow(() -> new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())));
    }
}
