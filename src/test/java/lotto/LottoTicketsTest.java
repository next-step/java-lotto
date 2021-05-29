package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

//    @DisplayName("생성자 체크 : TicketGenerator & int count")
//    @Test
//    void constructor_with_generator() {
//        //Given + When
//        LottoTickets tickets = new LottoTickets(new AutoLottoTicketGenerator(), 3);
//
//        //Then
//        assertThat(tickets).isNotNull();
//        assertThat(tickets.count()).isEqualTo(3);
//    }

    @DisplayName("생성자 체크 : List<LottoTicket>")
    @Test
    void constructor_with_list_lottoTicket() {
        //Given
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        tickets.add(new LottoTicket(Arrays.asList(5, 6, 7, 8, 9, 10)));

        //When
        LottoTickets lottoTickets = new LottoTickets(tickets);

        //Then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.count()).isEqualTo(2);
    }

    @DisplayName("티켓이 추가되는지 테스트")
    @Test
    void check_count_of_tickets_after_combine() {
        //Given
        List<LottoTicket> firstList = new ArrayList<>();
        firstList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTickets firstTickets = new LottoTickets(firstList);

        List<LottoTicket> secondList = new ArrayList<>();
        secondList.add(new LottoTicket(Arrays.asList(8, 9, 10, 11, 12, 13)));
        LottoTickets lottoTickets = new LottoTickets(secondList);

        //When
        lottoTickets.combineWith(firstTickets);

        //Then
        assertThat(lottoTickets.count()).isEqualTo(2);
    }
}
