package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickTicketsTest {
    
    @Test
    @DisplayName("수동 로또 생성 테스트")
    void quickTicketsTest(){
        final LottoTicket quickTicketA = new LottoTicket();
        final LottoTicket quickTicketB = new LottoTicket();
        
        QuickTickets actual = new QuickTickets(List.of(quickTicketA, quickTicketB));

        assertThat(actual.ticketCount()).isEqualTo(2L);
        assertThat(actual.quickTickets()).contains(quickTicketA, quickTicketB);
    }
}
