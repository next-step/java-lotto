package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void 요구한_개수만큼_로또티켓_생성테스트(int numberOfTickets) {
        List<LottoTicket> tickets = LottoTicketFactory.generateRandomGames(numberOfTickets);
        assertThat(tickets.size()).isEqualTo(numberOfTickets);
    }
}