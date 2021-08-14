package lotto.ticketingway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoPurchaseOrder;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.TicketCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ManualWayTest {

    @ParameterizedTest
    @MethodSource("provideManualOrder")
    @DisplayName("원하는 수만큼의 수동로또티켓을 사용자가 주문시 입력한 번호들만큼 발행할수있다.")
    void name(TicketCount count, LottoPurchaseOrder order, int expectedCount) {
        ManualWay way = new ManualWay();
        List<LottoTicket> tickets = way.issueLottoTickets(count, order);
        assertThat(tickets.size()).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> provideManualOrder() {
        return Stream.of(
            Arguments.of(new TicketCount(1), getZeroManualOrder(), 0),
            Arguments.of(new TicketCount(1), getOneManualOrder(), 1),
            Arguments.of(new TicketCount(2), getTwoManualOrder(), 2)
        );
    }

    private static LottoPurchaseOrder getZeroManualOrder() {
        return new LottoPurchaseOrder(new Money(3000),
            new int[][]{});
    }

    private static LottoPurchaseOrder getOneManualOrder() {
        return new LottoPurchaseOrder(new Money(3000),
            new int[][]{{1, 2, 3, 4, 5, 6}});
    }

    private static LottoPurchaseOrder getTwoManualOrder() {
        return new LottoPurchaseOrder(new Money(3000),
            new int[][]{{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}});
    }
}