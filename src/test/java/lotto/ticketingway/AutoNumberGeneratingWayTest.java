package lotto.ticketingway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.exception.NotEnoughTicketCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AutoNumberGeneratingWayTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "100,100",})
    @DisplayName("로또 티켓 자동생성방식 사용시, 원하는 티켓수를 입력하는것만으로 그수만큼의 로또 티켓을 얻을수 있다.")
    void issue_auto_way_lotto_tickets(int ticketCount, int expectedSize) {
        AutoNumberGeneratingWay autoWay = new AutoNumberGeneratingWay();
        List<LottoTicket> tickets = autoWay.issueLottoTickets(ticketCount);

        assertThat(tickets.size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    @DisplayName("로또 티켓 자동생성방식 사용시, 원하는 티켓수가 1장 미만일때 예외를 던진다.")
    void issue_auto_way_lotto_tickets_not_enough_count(int ticketCount) {
        AutoNumberGeneratingWay autoWay = new AutoNumberGeneratingWay();

        assertThatThrownBy(() -> autoWay.issueLottoTickets(ticketCount))
            .isInstanceOf(NotEnoughTicketCountException.class);
    }


}