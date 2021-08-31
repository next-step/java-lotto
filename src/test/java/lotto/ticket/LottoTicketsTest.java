package lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓 리스트는")
class LottoTicketsTest {
    @DisplayName("n장의 로또 티켓으로 초기화 된다. ")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersForEachTicketAndTotalTicketCount")
    void createLottoTickets(int[][] ticketNumbers, int ticketCount) {
        assertThat(new LottoTickets(ticketNumbers).value().size()).isEqualTo(ticketCount);
    }

    private static Stream<Arguments> provideLottoNumbersForEachTicketAndTotalTicketCount() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 7}, {1, 2, 3, 4, 8, 7}}, 3)
        );
    }
}
