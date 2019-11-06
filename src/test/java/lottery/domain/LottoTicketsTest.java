package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    private LottoTicketSeller seller;
    private List<Integer> winNumbers;
    private List<LottoTicket> tickets = new ArrayList<>();

    @BeforeEach
    void setUp() {
        seller = new LottoTicketSeller();
        winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 6));
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 7));
    }

    @Test
    void 생성테스트() {
        assertThat(new LottoTickets(tickets).size()).isEqualTo(2);
    }
}