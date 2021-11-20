package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsTest {

    @ParameterizedTest
    @DisplayName("n개 만큼 로또티켓 생성")
    @ValueSource(ints = {4, 5, 6})
    void generateAutoTickets(int count) {
        LottoTickets tickets = new LottoTickets();
        assertThat(tickets.autoLottoTicket(count).size()).isEqualTo(count);
    }

}
