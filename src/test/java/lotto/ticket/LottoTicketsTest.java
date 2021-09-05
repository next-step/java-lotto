package lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 티켓 리스트는")
class LottoTicketsTest {
    @DisplayName("n장의 로또 티켓으로 초기화: (로또 번호가 주어지는 경우)")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersForEachTicketAndTotalTicketCount")
    void createLottoTickets(List<LottoTicket> tickets, int ticketCount) {
        assertThat(new LottoTickets(tickets).value().size()).isEqualTo(ticketCount);
    }

    private static Stream<Arguments> provideLottoNumbersForEachTicketAndTotalTicketCount() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(1, 2, 3, 4, 5, 6),
                new LottoTicket(1, 2, 3, 4, 5, 7),
                new LottoTicket(1, 2, 3, 4, 8, 7)
        );
        return Stream.of(
                Arguments.of(tickets, 3)
        );
    }

    @DisplayName("n장의 로또 티켓으로 초기화 된다.: (로또 티켓 장수가 주어지는 경우)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createLottoTicketsWithCount(int ticketCount) {
        assertThat(new LottoTickets(ticketCount).value().size()).isEqualTo(ticketCount);
    }

    @DisplayName("로또 티켓 수는 양수")
    @Test
    void numberOfLottoTicketsHasToBePositive() {
        assertThatThrownBy(() -> new LottoTickets(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("티켓 수는 양수입니다.");
    }

    @DisplayName("자동 티켓과 수동 티켓의 장수를 반환한다.")
    @Test
    void countAutoTicketAndManualTicket() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        LottoTicket manual = new LottoTicket(TicketType.AUTO, numbers);
        LottoTicket auto = new LottoTicket(TicketType.MANUAL, numbers);
        LottoTickets tickets = new LottoTickets(Arrays.asList(manual, auto));
        assertThat(tickets.manualTicketCount()).isEqualTo(1);
        assertThat(tickets.autoTicketCount()).isEqualTo(1);
    }


    private static Stream<Arguments> provideLottoTicketWithItsPrize() {
        return Stream.of(
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 6)),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 45), 45, Prize.SECOND),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 7), 30, Prize.THIRD),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 8, 7), 30, Prize.FOURTH),
                Arguments.of(new LottoTicket(1, 2, 3, 9, 8, 7), 30, Prize.FIFTH),
                Arguments.of(new LottoTicket(1, 2, 10, 9, 8, 7), 30, Prize.LOSER),
                Arguments.of(new LottoTicket(1, 11, 10, 9, 8, 7), 30, Prize.LOSER),
                Arguments.of(new LottoTicket(12, 11, 10, 9, 8, 7), 30, Prize.LOSER)
        );
    }
}
