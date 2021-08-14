package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketMachineTest {

    LottoTicketMachine machine = LottoTicketMachine.getInstance();

    @ParameterizedTest
    @MethodSource("provideOrderInfo")
    @DisplayName("입력한 개수만큼 수동로또티켓을 발행할수 있다.")
    void manual_ticket_creation(TicketCount count, LottoPurchaseOrder order, int expectedCount) {
        ManualLottoTickets manualTickets = machine.issueTicketsByManualWay(count, order);
        assertThat(manualTickets.getCount()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @MethodSource("provideOrderInfo")
    @DisplayName("입력한 개수만큼 자동로또티켓을 발행할수 있다.")
    void auto_ticket_creation(TicketCount count, LottoPurchaseOrder order, int expectedCount) {
        AutoLottoTickets autoTickets = machine.issueTicketsByAutoWay(count);
        assertThat(autoTickets.getCount()).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> provideOrderInfo() {
        return Stream.of(
            Arguments.of(new TicketCount(1), getOneManualOrder(), 1),
            Arguments.of(new TicketCount(2), getTwoManualOrder(), 2)
        );
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