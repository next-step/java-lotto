package lotto.domian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoTicketsTest {

    private LottoNumberGenerator generator;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        generator = mock(LottoNumberGenerator.class);
        lottoTickets = LottoTickets.of(5,generator);
        when(generator.generateRandomLottoNumbers()).thenReturn(new ArrayList<>());
    }

    @Test
    @DisplayName("주어진 티켓 수와 같은 사이즈의 LottoTicket 리스트 생성")
    void givenTicketCountAndGenerator_thenCreatesLottoTickets(){
        int ticketCount = 5;
        LottoTickets tickets = LottoTickets.of(ticketCount, generator);
        assertThat(tickets.getLottoTickets()).hasSize(ticketCount);
    }

}
