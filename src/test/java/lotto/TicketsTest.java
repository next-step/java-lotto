package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.RandomNumberGeneration;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class TicketsTest {

    @Test
    @DisplayName("로또를 정상적으로 생성한다")
    void createTickets() {
        //given
        LottoTicket ticket = new LottoTicket(Set.of(1,2,3,4,5,6));

        //when
        LottoTickets tickets = new LottoTickets(List.of(ticket));

        //then
        assertThat(tickets.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("두 로또를 합친다")
    void mergeTickets() {
        //given
        LottoTicket ticket = new LottoTicket(Set.of(1,2,3,4,5,6));
        LottoTickets tickets1 = new LottoTickets(List.of(ticket));
        LottoTickets tickets2 = new LottoTickets(List.of(ticket));

        //when
        LottoTickets mergedTickets = tickets1.merge(tickets2);

        //then
        assertThat(mergedTickets.size()).isEqualTo(2);
    }

}