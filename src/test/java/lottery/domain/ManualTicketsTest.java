package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualTicketsTest {

    @Test
    @DisplayName("수동 로또 생성 테스트")
    void manualTicketsTest(){
        final LottoTicket manualTicketA = new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6});
        final LottoTicket manualTicketB = new LottoTicket(new Integer[]{2, 3, 4, 5, 6, 8});

        ManualTickets actual = new ManualTickets(List.of(manualTicketA, manualTicketB));

        assertThat(actual.ticketCount()).isEqualTo(2L);
        assertThat(actual.manualTickets()).contains(manualTicketA, manualTicketB);
    }
}
