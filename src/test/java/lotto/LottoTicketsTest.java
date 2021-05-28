package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("생성")
    @Test
    void create(){
        //Given + When
        LottoTickets tickets = new LottoTickets(new AutoLottoTicketGenerator(), 3 );

        //Then
        assertThat(tickets).isNotNull();
        assertThat(tickets.count()).isEqualTo(3);
    }

    @DisplayName("입력한 티켓이 추가되는지 테스트")
    @Test
    void check_count_of_tickets_after_combine() {
        //Given
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoTickets lottoTickets = new LottoTickets(tickets);

        //When
        lottoTickets.combineWith(tickets);

        //Then
        assertThat(lottoTickets.count()).isEqualTo(2);
    }
}
